# -*- coding: UTF-8 -*-
# import pymongo
from xml.dom.minidom import parse
import xml.dom.minidom
import datetime
import os
from os.path import join

# def connect_mongodb():
#     servers = "mongodb://121.196.244.53:27017"
#     conn = pymongo.MongoClient(servers)
#     db = conn.test
#     return db


def check(tag_name):
    tags = [ 'WSMC', 'AH', 'AJLB','WSZL','SPCX', 'BGRQX','SSXZ','ESAJLY','SSHKSFW','YGSJG','SPZZ','ZZQK','ESJAFS']
    if tag_name in tags:
        return True
    return False


# 是和否需要boolean值
def check_boolean(node):
    dict={}
    tags = ['KTSL','JCYJYYQSL','SNFT','GXQYY','KTQSQCHSS','ESFH']
    tag_name = node.nodeName
    key = node.getAttribute("nameCN")
    value = node.getAttribute("value")
    check_tag = True
    if tag_name in tags:
        if value == '否':
            check_tag = False
        dict[key] = check_tag
    return dict

# 处理公诉方
def analyse_GSF(father_node):
    dict = {}
    child_dict = {}
    childNodes = father_node.childNodes
    for node in childNodes:
        if node.nodeType != node.TEXT_NODE:
            child_dict[node.getAttribute("nameCN")] = node.getAttribute("value")
    dict['公诉方'] = child_dict
    return dict


# 处理起诉方和应诉方,传递过来的是数组
def analyse_QSF(father_node_array):
    child_array=[]
    tag_name=['SSCYR','SSSF','DSRLX','GJ','DSRLB','XSZRNL','BSSSDW','YSSSDW','SSRYBGRGX','ZRRSF']
    tag_boolean_name=['HXKYQNFZ','JSKYQNFZ','SFBHR']
    for father_node in father_node_array:
        child_dict = {}
        childNodes = father_node.childNodes
        for node in childNodes:
            if node.nodeType != node.TEXT_NODE:
                tag=node.nodeName
                key=node.getAttribute("nameCN")
                if tag in tag_name:
                    child_dict[key] = node.getAttribute("value")
                if tag in tag_boolean_name:
                    if node.getAttribute("value") == '否':
                        child_dict[key] = False
                    else:
                        child_dict[key] = True
        q_nodes=father_node.getElementsByTagName('QKLJ')
        if(len(q_nodes) != 0) :
            child_dict = dict(child_dict, **analyse_QKLJ(q_nodes))

        child_array.append(child_dict)

    return child_array

#处理前科劣迹
def analyse_QKLJ(father_node_array):
    tag_name = ['QKLB',  'CFDW', 'CFXS', 'CFFQ']
    dict = {}
    child_array = []
    for father_node in father_node_array:
        child_dict = {}
        childNodes = father_node.childNodes
        for node in childNodes:
            tag=node.nodeName
            key=node.getAttribute("nameCN")
            if tag in tag_name:
                child_dict[key] = node.getAttribute("value")
            if tag == 'CFSJ':
                child_dict[key] = time_tool(node.getAttribute("value"))
            if tag == 'CFYYZ':
                if(len(node.childNodes) != 0):
                    CFYY=node.childNodes[0]
                    child_dict['处罚原因'] = CFYY.getAttribute("value")

    child_array.append(child_dict)

    dict['前科劣迹'] = child_array
    return dict

#将字符串的时间转化为时间格式
def time_tool(time):
    if '月' not in time :
        time = time + "null月"
    if '日' not in time :
        time = time + "null日"

    index=time.find("年")
    year=int(time[:index])
    if year< 1000:
        return
    else :
        return datetime.datetime.strptime(time.replace('null', '1').replace('О', '0').replace('Ｏ', '0'), '%Y年%m月%d日')

# 处理原告被告
def analyse_litigant(father_node):
    dict = {}
    plaintiff = []  # 原告
    defendant = []  # 被告
    public_prosecution = []  # 公诉机关
    litigants = father_node.childNodes
    for litigant in litigants:
        if litigant.nodeType != litigant.TEXT_NODE:
            childNodes = litigant.childNodes
            for i in range(len(childNodes) - 2):
                node = childNodes[i]
                next_node = childNodes[i + 2]
                if node.nodeType != node.TEXT_NODE and next_node.nodeType != next_node.TEXT_NODE:
                    if '诉讼身份' in next_node.getAttribute("nameCN"):
                        if '原告' in next_node.getAttribute("value"):
                            plaintiff.append(node.getAttribute("value"))
                        if '被告' in next_node.getAttribute("value"):
                            defendant.append(node.getAttribute("value"))
                        if '公诉机关' in next_node.getAttribute("value"):
                            public_prosecution.append(node.getAttribute("value"))
    if len(plaintiff) != 0:
        dict["原告"] = plaintiff
    if len(defendant) != 0:
        dict["被告"] = defendant
    if len(public_prosecution) != 0:
        dict["公诉机关"] = public_prosecution
    return dict


# 处理法条
def analyse_law(father_node):
    dicto = {}
    child_array = []
    father_node_array = father_node.childNodes
    for father_node in father_node_array:
        child_dict = {}
        law_t=[]
        for node in father_node.childNodes:
            if node.nodeName == 'MC':
                child_dict[node.getAttribute("nameCN")] = node.getAttribute("value")
            if node.nodeName == 'T':
                law_t.append(node.getAttribute("value"))
        child_dict['条目'] = law_t

        child_array.append(child_dict)

    dicto['法律法条引用'] = child_array
    return dicto


# 处理诉讼记录
def analyse_judgment_section(father_node):
    dict = {}
    judgment_entry = []  # 具体裁判段
    entries = father_node.childNodes
    for entry in entries:
        if (entry.nodeType != entry.TEXT_NODE) and (entry.nodeName == 'JTPJJG'):
            judgment_entry.append(entry.getAttribute('value'))

    if len(judgment_entry)!=0:
        dict["具体裁判段"] = judgment_entry
    return dict


# 处理具体裁判段
def analyse_judgment_section(father_node):
    dict = {}
    judgment_entry = []  # 具体裁判段
    entries = father_node.childNodes
    for entry in entries:
        if (entry.nodeType != entry.TEXT_NODE) and (entry.nodeName == 'JTPJJG'):
            judgment_entry.append(entry.getAttribute('value'))

    if len(judgment_entry)!=0:
        dict["具体裁判段"] = judgment_entry
    return dict


# 处理刑事判决结果分组
def analyse_criminal_judgment(father_node):
    dict = {}
    judgment_entry = {}  # 刑事判决结果分组

    father_node = father_node.getElementsByTagName('XSPJJGFZ')
    if len(father_node) == 0:
        return {}

    father_node=father_node[0]

    PJZZM = father_node.getElementsByTagName('PJZZM')
    if len(PJZZM) != 0:
        PJZZM = PJZZM[0]
        judgment_entry['判决主罪名'] = PJZZM.getAttribute("value")

    DZPF = father_node.getElementsByTagName('DZPF')
    if len(DZPF) != 0:
        DZPF = DZPF[0]
        judgment_entry['单罪判罚'] = DZPF.getAttribute("value")

    ZXPF = father_node.getElementsByTagName('ZXPF')
    if len(ZXPF) != 0:
        ZXPF = ZXPF[0]
        judgment_entry['执行判罚'] = ZXPF.getAttribute("value")

    if len(judgment_entry) != 0:
        dict["刑事判决结果分组"] = judgment_entry
    return dict


# 处理审判员书记员
def analyse_judge_person(father_node):
    dicto = {}
    child_array = []
    father_node_array = father_node.childNodes
    for father_node in father_node_array:
        if father_node.nodeName != 'CPSJ':
            child_dict = {}
            for node in father_node.childNodes:
                if node.nodeType == node.TEXT_NODE: continue
                child_dict[node.getAttribute("nameCN")] = node.getAttribute("value")
            child_array.append(child_dict)

    dicto['审判组织成员'] = child_array
    return dicto


# 处理冒号
def deal_with_str(value):
    if "：" in value:
        pos = value.index("：")
        if pos != -1 :
            value = value[pos+1:]

    return value


# 处理裁判时间
def analyse_time(father_node):
    dict={}
    time=time_tool(father_node.getAttribute('value'))
    dict['裁判时间']=time
    return dict


# 处理经办法院
def analyse_JBFY(father_node):
    dict={}
    child_dict={}
    childNodes=father_node.childNodes
    for node in childNodes:
        if node.nodeType != node.TEXT_NODE:
            child_dict[node.getAttribute("nameCN")]=node.getAttribute("value")
    dict['经办法院']=child_dict
    return dict


# 处理代理人
def analyse_DLR(father_node_array):
    dicto = {}
    child_array=[]
    for father_node in father_node_array:
        child_dict = {}
        childNodes = father_node.childNodes
        for node in childNodes:
            tag=node.nodeName
            key=node.getAttribute("nameCN")
            if(tag != 'DWZWFZ'):
                child_dict[key] = node.getAttribute("value")
            else:
                ZW=node.getElementsByTagName('ZW')
                if len(ZW) != 0 : child_dict['单位职务'] = ZW[0].getAttribute("value")
                DWMC = node.getElementsByTagName('DWMC')
                if len(DWMC) != 0: child_dict['单位名称'] = DWMC[0].getAttribute("value")
                DWXZ = node.getElementsByTagName('DWXZ')
                if len(DWXZ) != 0: child_dict['单位性质'] = DWXZ[0].getAttribute("value")

        child_array.append(child_dict)

    dicto['代理人'] = child_array
    return dicto

#处理指控信息
def analyse_charge(father_node):
    dicto = {}
    child_array = []
    father_node_array = father_node.childNodes
    for father_node in father_node_array:
        child_dict={}
        if father_node.nodeType == father_node.TEXT_NODE: continue
        ZKZM_array = father_node.getElementsByTagName('ZKZM')
        ZKZM_arr = []
        for zkzm in ZKZM_array :
            zkzm_dict = {}
            for node in zkzm.childNodes:
                if node.nodeType == node.TEXT_NODE: continue
                zkzm_dict[node.getAttribute('nameCN')] = node.getAttribute('value')
            ZKZM_arr.append(zkzm_dict)
        child_dict['指控罪名'] = ZKZM_arr
        XGR = father_node.getElementsByTagName('XGR')
        xgr_arr = []
        for xgr in XGR:
            xgr_arr.append(xgr.getAttribute('value'))
        child_dict['相关人'] = xgr_arr

        child_array.append(child_dict)

    dicto['指控信息'] = child_array
    return dicto


# 处理起诉主案由
def analyse_QSZAY(father_node):
    dict={}
    child_dict={}
    childNodes=father_node.childNodes
    for node in childNodes:
        if node.nodeType == node.TEXT_NODE: continue
        child_dict[node.getAttribute("nameCN")]=node.getAttribute("value")
    dict['起诉主案由']=child_dict
    return dict


# 处理其他起诉案由
def analyse_QTQSAY(father_node):
    dicto = {}
    child_array = []
    father_node_array = father_node.childNodes
    for father_node in father_node_array:
        child_dict = {}

        for node in father_node.childNodes:
            child_dict[node.getAttribute("nameCN")] = node.getAttribute("value")

        child_array.append(child_dict)

    dicto['其他起诉案由'] = child_array
    return dicto


# 处理案件由来与审理经过段
def analyse_AJYLYSLJGD(father_node):
    dict={}
    child_dict={}
    childNodes=father_node.childNodes
    for node in childNodes:
        if node.nodeType == node.TEXT_NODE: continue
        tag=node.nodeName
        if tag == 'QSFY':
            qdict={}
            for q_node in node.childNodes:
                if q_node.nodeType == q_node.TEXT_NODE: continue
                qdict[q_node.getAttribute("nameCN")] = q_node.getAttribute("value")
            child_dict['前审法院']=qdict
        elif tag == 'QSCPSJ':
            child_dict[node.getAttribute("nameCN")] = time_tool(node.getAttribute("value"))
        else:
            child_dict[node.getAttribute("nameCN")] = node.getAttribute("value")

    dict['案件由来与审理经过段']=child_dict
    return dict


#获得bson
def xml_to_bson(filepath):
    DOMTree = xml.dom.minidom.parse(filepath)

    bson_dict = {}

    writ = DOMTree.documentElement  # 最外层的结构

    QW=writ.getElementsByTagName('QW')[0]

    primary_directory = QW.childNodes  # 一级目录

    # 处理全文
    article = {}
    for node in primary_directory:
        if node.nodeType != node.TEXT_NODE and node.nodeName not in ['CUS_SJ','title','subTitle','WSSFMH']:
            article[node.getAttribute("nameCN")] = node.getAttribute("value")
    bson_dict["全文"] = article

    for directory in primary_directory:
        second_level_directory = directory.childNodes  # 二级目录
        for node in second_level_directory:
            if node.nodeType != node.TEXT_NODE:
                bson_dict = dict(bson_dict, **check_boolean(node))
                if check(node.nodeName):
                    bson_dict[node.getAttribute("nameCN")] = node.getAttribute("value")
                if node.nodeName=='GSF':
                    bson_dict = dict(bson_dict, **analyse_GSF(node))
                if node.nodeName == 'QSF':
                    node_array=directory.getElementsByTagName('QSF')
                    bson_dict['起诉方'] = analyse_QSF(node_array)
                if node.nodeName == 'YSF':
                    node_array = directory.getElementsByTagName('YSF')
                    bson_dict['应诉方'] = analyse_QSF(node_array)
                if node.nodeName == 'DLR':
                    node_array = directory.getElementsByTagName('DLR')
                    bson_dict = dict(bson_dict, **analyse_DLR(node_array))
                if node.nodeName=='CPSJ':
                    bson_dict = dict(bson_dict, **analyse_time(node))
                if node.nodeName == 'JBFY':
                    bson_dict = dict(bson_dict, **analyse_JBFY(node))
                if node.nodeName == 'ZKXX':
                    bson_dict = dict(bson_dict, **analyse_charge(node))
                if node.nodeName == 'QSZAY':
                    bson_dict = dict(bson_dict, **analyse_QSZAY(node))
                if node.nodeName == 'QTQSAY':
                    bson_dict = dict(bson_dict, **analyse_QTQSAY(node))
                if node.nodeName == 'AJYLYSLJGD':
                    bson_dict = dict(bson_dict, **analyse_AJYLYSLJGD(node))
                #处理法条
                if node.nodeName == 'FLFTYY':
                    bson_dict = dict(bson_dict, **analyse_law(node))
                if node.nodeName in ['GPYY','CSLX','FHCSDYY']:
                    bson_dict['结案原因'] = node.getAttribute('value')


        if directory.nodeName == 'WW':
            bson_dict = dict(bson_dict, **analyse_judge_person(directory))

        if directory.nodeName == 'title':
            bson_dict['文书标题'] = directory.getAttribute("value")

        if directory.nodeName == 'subTitle':
            bson_dict['文书副标题'] = directory.getAttribute("value")

    return bson_dict


#获得所有文件路径
def get_all_filename(dir, withPath= True):
    """
    :param dir:  dir to walk path
    :param withPath:  wether return abslutely path
    :return:   {list}  path list
    author: wsw
    """
    list = []
    for _,_,files in os.walk(dir):
        for file in files:
            temp = join(dir,file) if withPath else file
            list.append(temp)

    return list


dir = '/Users/green-cherry/学习/大二暑期/卓越工程师/文书/2组/测试集/'
path=get_all_filename(dir)
for filepath in path:
    print(filepath)
    bson = xml_to_bson(filepath)



    # db = connect_mongodb()

    # print(bson)