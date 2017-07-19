var React = require('react')

<<<<<<< HEAD
var CaseContext = function(props) {
    var info = props.caseInfo;

    return <div className="case-context">
=======
function generateContext(content, n) {
    var urls = ['context-head', 'context-participants', 'context-records', 'context-situation',
        'context-analysis', 'context-result', 'context-tail', 'context-appendix']
    if(content === '')
        return null;
    return <p id={urls[n]}>{content}</p>
}

var CaseContext = function(props) {
    var info = props.caseInfo;

    console.log(info)

    return <div className="case-context" id="case-context">
>>>>>>> b9db0c393e76fd8f6e621a6974b7f99df76d85e4
        <div className="general-info-title">
            原文
        </div>
        <div className="context-content">
<<<<<<< HEAD
            <div className="context-title">
                中华人民共和国最高人民法院
                行 政 判 决 书
            </div>
            <div className="context-text">
                再审申请人（一审原告、二审上诉人）：耐克国际有限公司。住所地：美利坚合众国俄勒冈州比弗敦鲍尔曼道1号。
                法定代表人：JohnF.Coburn，III，该公司助理秘书。
                法定代表人：AnnM.Miller，该公司助理秘书。
                委托代理人：李晓红，北京市正见永申律师事务所律师。
                委托代理人：王珊珊，北京市正见永申律师事务所律师。
                被申请人（一审被告、二审被上诉人）：中华人民共和国国家工商行政管理总局商标评审委员会。住所地：中华人民共和国北京市西城区茶马南街1号。
                法定代表人：何训班，该委员会主任。
                委托代理人：覃莎莎，该委员会审查员。
                再审申请人耐克国际有限公司（简称耐克公司）因与被申请人中华人民共和国国家工商行政管理总局商标评审委员会（简称商标评审委员会）商标驳回复审行政纠纷一案，不服北京市高级人民法院（2011）高行终字第1550号行政判决（简称二审判决），向本院申请再审。本院依法受理后，于2012年11月13日作出（2012）知行字第52号行政裁定书，裁定中止审查。2014年12月13日，本院作出（2012）知行字第52-1号行政裁定，提审本案。本院依法组成合议庭，于2015年5月28日公开开庭审理了本案。耐克公司委托代理人王珊珊，商标评审委员会委托代理人覃莎莎到庭参加诉讼。本案现已审理终结。
                商标评审委员会答辩认为，涉案第16939号决定作出时引证商标三尚未进入异议程序，其根据引证商标三当时的法律状态作出的复审决定意见，并无不当。如果法院现在判令其根据变化后的事实重新作出决定，作为个案亦服从法院判决。
                虽然涉案第16939号决定作出时引证商标三尚未进入异议程序，但商标评审委员会在耐克公司已经提出暂缓审理申请，且其他相关案件处理结果也表明引证商标三可能存在法律状态不稳定因素的情况下，未予暂缓宽限，亦有不妥。本院审理期间，商标评审委员会作出第144378号裁定书，裁定引证商标三不予核准注册，并已发生法律效力。商标评审委员会作出第16939号决定的事实基础已经发生变化。由商标评审委员会根据新的事实重新作出决定，不仅可以弥补本案审理程序上存在的瑕疵，亦可避免耐克公司因此遭受的利益损害。
                综上，耐克公司申请再审理由成立，本院依法予以支持。依照《中华人民共和国行政诉讼法（2014年修正）》第八十九条第一款第（二）项、《最高人民法院关于执行﹤中华人民共和国行政诉讼法﹥若干问题的解释》第七十六条第一款、第七十八条之规定，判决如下：
                一、撤销中华人民共和国北京市高级人民法院（2011）高行终字第1550号行政判决、中华人民共和国北京市第一中级人民法院（2011）一中知行初字第485号行政判决；
                二、撤销中华人民共和国国家工商行政管理总局商标评审委员会商评字（2010）第16939号《关于第4903847号“勒布朗-詹姆斯”商标驳回复审决定》；
                三、中华人民共和国国家工商行政管理总局商标评审委员会重新作出决定。
                一、二审案件受理费各100元，均由中华人民共和国国家工商行政管理总局商标评审委员会负担。
                本判决为终审判决。
                审　判　长　　夏君丽
                审　判　员　　殷少平
                代理审判员　　曹　刚

                二〇一五年七月一日
                书　记　员　　包　硕
                附图：
                申请商标
                引证商标三
            </div>
=======
            {generateContext(info.context.head, 0)}<br/>
            {generateContext(info.context.participants, 1)}<br/>
            {generateContext(info.context.records, 2)}<br/>
            {generateContext(info.context.situation, 3)}<br/>
            {generateContext(info.context.analysis, 4)}<br/>
            {generateContext(info.context.result, 5)}<br/>
            {generateContext(info.context.tail, 6)}<br/>
            {generateContext(info.context.appendix, 7)}
>>>>>>> b9db0c393e76fd8f6e621a6974b7f99df76d85e4
        </div>
    </div>;
}

module.exports = CaseContext;