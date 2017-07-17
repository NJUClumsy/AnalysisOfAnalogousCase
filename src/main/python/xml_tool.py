# -*- coding: UTF-8 -*-
# import pymongo
from xml.dom.minidom import parse
import xml.dom.minidom

# def connect_mongodb():
#     servers = "mongodb://121.196.244.53:27017"
#     conn = pymongo.MongoClient(servers)
#     db = conn.test
#     return db


def check(tag_name):
    tags = ['JBFY', 'WSMC', 'AH', 'SPCX', 'GSJG', 'AY', 'KTSLXX', 'YGSCD', 'BGBCD', 'CMSSD']
    if tag_name in tags:
        return True
    return False


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
    dict = {}
    legal_entry = []  # 法律条目
    laws = father_node.childNodes
    if len(laws) == 0:
        return {}
    for law in laws:
        law_entry={}
        if (law.nodeType != law.TEXT_NODE) and (law.nodeName == 'FLFTMC'):
            childNodes = law.childNodes
            entries = []
            for entry in childNodes:
                if entry.nodeType != entry.TEXT_NODE:
                    entries.append(entry.getAttribute('value'))
            law_entry['法条名称'] = law.getAttribute('value')
            law_entry['引用条目'] = entries
        if len(law_entry) != 0:
            legal_entry.append(law_entry)
    if len(legal_entry) !=0:
        dict["法条"] = legal_entry
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
    dict = {}
    judge_person = []  # 审判员

    entries = father_node.getElementsByTagName('SPZZCY')

    if len(entries) == 0:
        return {}

    for entry in entries:
        if entry.nodeType != entry.TEXT_NODE:
            SPRYJS=entry.getElementsByTagName('SPRYJS')
            if len(SPRYJS) != 0:

                if '审判员' in SPRYJS[0].getAttribute('value'):
                    SPRYXM=entry.getElementsByTagName('SPRYXM')
                    if len(SPRYXM) != 0 :
                        value=SPRYXM[0].getAttribute('value')
                        value=deal_with_str(value)
                        if value != "":
                            judge_person.append(value)

                if SPRYJS[0].getAttribute('value') == '书记员':
                    SPRYXM = entry.getElementsByTagName('SPRYXM')
                    if len(SPRYXM) != 0:
                        value = SPRYXM[0].getAttribute('value')
                        value = deal_with_str(value)
                        if value != "":
                            dict["书记员"] = value

    if len(judge_person) != 0:
        dict["审判员"] = judge_person
    return dict


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
    year=father_node.getElementsByTagName('Year')
    year = year[0].getAttribute('value') if len(year) != 0 else 'null'

    month = father_node.getElementsByTagName('Month')
    month = month[0].getAttribute('value') if len(month) != 0 else 'null'

    day = father_node.getElementsByTagName('Day')
    day = day[0].getAttribute('value') if len(day) != 0 else 'null'

    time=year+"年"+month+"月"+day+"日"
    dict['裁判时间']=time
    return dict


def xml_to_bson(filepath):
    DOMTree = xml.dom.minidom.parse(filepath)

    bson_dict = {}

    QW = DOMTree.documentElement  # 最外层的结构

    primary_directory = QW.childNodes  # 一级目录

    # 处理全文
    article = {}
    for node in primary_directory:
        if node.nodeType != node.TEXT_NODE:
            article[node.getAttribute("nameCN")] = node.getAttribute("value")
    bson_dict["全文"] = article

    for directory in primary_directory:
        second_level_directory = directory.childNodes  # 二级目录
        for node in second_level_directory:
            if node.nodeType != node.TEXT_NODE:
                if check(node.nodeName):
                    bson_dict[node.getAttribute("nameCN")] = node.getAttribute("value")
                if node.nodeName=='CPSJ':
                    bson_dict = dict(bson_dict, **analyse_time(node))
                if node.nodeName=='ZKDL':
                    bson_dict['原告诉称段'] = node.getAttribute("value")
                if node.nodeName=='BHDL':
                    bson_dict['被告辩称段'] = node.getAttribute("value")
                if node.nodeName=='BSSLD':
                    bson_dict['查明事实段'] = node.getAttribute("value")

        # 处理原被告
        if directory.nodeName == 'SSCYRQJ':
            bson_dict = dict(bson_dict, **analyse_litigant(directory))

        # 处理法条
        if directory.nodeName == 'CPFXGC':
            bson_dict = dict(bson_dict, **analyse_law(directory))

        # 处理具体裁判段
        if directory.nodeName == 'CPJG':
            bson_dict = dict(bson_dict, **analyse_judgment_section(directory))

        # 处理刑事判决结果分组
        if directory.nodeName == 'PJJG':
            bson_dict = dict(bson_dict, **analyse_criminal_judgment(directory))

        # 处理审判员和书记员
        if directory.nodeName == 'WW':
            bson_dict = dict(bson_dict, **analyse_judge_person(directory))


    # print(bson_dict.keys())
    # print(bson_dict['法条'])
    # result = json.dumps(bson_dict, ensure_ascii=False)  # 将字典格式转成bson，同时解决编码问题
    return bson_dict


filepath = "/Users/green-cherry/学习/大二暑期/文书/g.xml"
bson = xml_to_bson(filepath)
# db = connect_mongodb()

print(bson)