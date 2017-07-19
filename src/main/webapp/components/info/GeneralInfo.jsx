var React = require('react')
import '../../util/Validation'

function checkInfoVal(text) {
    if(text === '')
        return '暂无信息';
    return text;
}

function checkArrayVal(array) {
    if(array === [])
        return '暂无信息';
    return array.map(function (item, i) {
        return <span key={i}>{item} </span>;
    });
}

function getLawName(array) {
    if(array === [])
        return '暂无信息';
    var law = array.map(function (item, i, array) {
        if(i === array.length - 1)
            return <span key={i}>{ item.lawName } <span>{getCiteString(item.cite)}</span> </span>;
        return <span key={i}>{ item.lawName } <span>{getCiteString(item.cite)}</span> ，</span>;
    });
    return law
}

function getCiteString(array) {
    if(array === [])
        return '暂无信息';
    return array.map(function (item, i, array) {
        if(i === array.length - 1)
            return '第' + item + '条' ;
        return '第' + item + '条' + '、';
    });
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
            <div className="general-info-row-unit">
                <div className="general-info-cell">
                    经办法院
                </div>
                <div className="general-info-cell">
                    文书名称
                </div>
                <div className="general-info-cell">
                    审判程序
                </div>
                <div className="general-info-cell">
                    原告
                </div>
                <div className="general-info-cell">
                    被告
                </div>
                <div className="general-info-cell">
                    具体裁判段
                </div>
                <div className="general-info-cell">
                    书记员
                </div>
                <div className="general-info-cell">
                    审判员
                </div>
                <div className="general-info-cell">
                    案由
                </div>
                <div className="general-info-cell general-info-row-l">
                    裁判时间
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m1">
                <div className="general-info-cell">
                    {checkInfoVal(info.court)}
                </div>
                <div className="general-info-cell">
                    {checkInfoVal(info.type)}
                </div>
                <div className="general-info-cell">
                    {checkInfoVal(info.process)}
                </div>
                <div className="general-info-cell">
                    {checkArrayVal(info.accuser)}
                </div>
                <div className="general-info-cell">
                    {checkArrayVal(info.defendant)}
                </div>
                <div className="general-info-cell">
                    {checkArrayVal(info.judgement1)}
                </div>
                <div className="general-info-cell">
                    {checkInfoVal(info.court_clerk)}
                </div>
                <div className="general-info-cell">
                    {checkArrayVal(info.judge)}
                </div>
                <div className="general-info-cell">
                    {checkInfoVal(info.cause)}
                </div>
                <div className="general-info-cell general-info-row-l">
                    {checkInfoVal(info.date)}
                </div>
            </div>
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell general-info-column-f">
                    引用法条
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m2">
                <div className="general-info-cell general-info-row-l">
                    {getLawName(info.law)}
                </div>
            </div>
        </div>
        <div className="general-info-row general-info-row-l">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell general-info-column-f">
                    判决结果
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m2">
                <div className="general-info-cell general-info-row-l">
                    {checkInfoVal(info.context.result)}
                </div>
            </div>
        </div>
    </div>;
}

module.exports = GeneralInfo;