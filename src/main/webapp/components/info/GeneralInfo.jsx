var React = require('react')

var null_info = <span style={{color: '#AAAAAA'}}>暂无信息</span>

function checkInfoVal(text) {
    if(text === '' || text === null)
        return null_info;
    return text;
}

function checkArrayVal(array) {
    if(array === null || array.length === 0)
        return null_info;
    return array.map(function (item, i) {
        return <span key={i}>{item} </span>;
    });
}

function getLawName(array) {
    if(array === null || array.length === 0)
        return null_info;
    var law = array.map(function (item, i, array) {
        if(i === array.length - 1)
            return <span key={i}>{ item.lawName } <span>{getCiteString(item.cite)}</span> </span>;
        return <span key={i}>{ item.lawName } <span>{getCiteString(item.cite)}</span> ，</span>;
    });
    return law
}

function getCiteString(array) {
    if(array === null || array.length === 0)
        return null_info;
    return array.map(function (item, i, array) {
        if(i === array.length - 1)
            return '第' + item + '条' ;
        return '第' + item + '条' + '、';
    });
}

// function getJudgement(judge1, judge2) {
//     if(judge1 === null && judge2 === null)
//         return null_info;
//     if (judge2 === null || judge2 === {})
//         return checkArrayVal(judge1);
//     else {
//         return <div>
//             <span>裁决主罪名： </span> <span>{judge2.main_charge}</span><br/>
//             <span>单罪判罚： </span> <span>{judge2.single_penalty}</span><br/>
//             <span>执行判罚： </span> <span>{judge2.exec_penalty}</span><br/>
//         </div>
//     }
// }

function checkDateVal (time) {
    if(time === null)
        return null_info;
    return <span>{time.year}-{time.monthValue}-{time.dayOfMonth}</span>
}

var GeneralInfo = function(props) {
    var info = props.caseInfo;

    return <div className="general-info" id="general-info">
        <div className="general-info-title">
            概要
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell general-info-column-f">
                    基本信息
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m1">
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 经办法院 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.court)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 文书名称 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.name)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 审判程序 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.judicialProcedure)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 应诉方 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkArrayVal(info.respondingParty)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 起诉方 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkArrayVal(info.prosecution)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 代理人 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkArrayVal(info.agents)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 公诉方 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.publicProsecution)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 起诉主案由 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.majorCause)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 原公诉机关 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.formerProcedureOrgan)} </div>
                    </div>
                </div>
                <div className="general-info-row">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell"> 二审结案方式 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell"> {checkInfoVal(info.closureWay)} </div>
                    </div>
                </div>
                <div className="general-info-row general-info-row-l">
                    <div className="general-info-row-unit general-info-column-f">
                        <div className="general-info-cell general-info-row-l"> 裁判时间 </div>
                    </div>
                    <div className="general-info-row-unit-2">
                        <div className="general-info-cell general-info-row-l"> {checkDateVal(info.date)} </div>
                    </div>
                </div>
            </div>
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell general-info-column-f"> 结案原因 </div>
            </div>
            <div className="general-info-row-unit general-info-column-m1">
                <div className="general-info-cell general-info-row-l"> {checkInfoVal(info.reason)} </div>
            </div>
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell general-info-column-f"> 引用法条 </div>
            </div>
            <div className="general-info-row-unit general-info-column-m1">
                <div className="general-info-cell general-info-row-l"> {getLawName(info.law)} </div>
            </div>
        </div>
        <div className="general-info-row general-info-row-l">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell general-info-column-f"> 判决结果 </div>
            </div>
            <div className="general-info-row-unit general-info-column-m1">
                <div className="general-info-cell general-info-row-l"> {checkInfoVal(info.context.result)} </div>
            </div>
        </div>
    </div>;
}

module.exports = GeneralInfo;