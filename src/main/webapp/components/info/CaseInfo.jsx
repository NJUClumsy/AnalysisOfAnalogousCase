var React = require('react')
var GeneralInfo = require('./GeneralInfoController')
var RecCase = require('./RecCaseController')
var CaseContext = require('./CaseContextController')
import { Link} from 'react-router';
import { BackTop } from 'antd';
import $ from 'jquery';

function scrollTo(ele, speed){
    if(!speed) speed = 500;
    if(!ele)
        $("html,body").animate({scrollTop:0},speed);
    else
        if(ele.length>0) $("html,body").animate({scrollTop:$(ele).offset().top},speed);
    return false;
}

function subAnchorTag(content, n) {
    var titles = ['文首', '当事人', '诉讼记录', '案件基本情况', '裁判分析过程', '裁判结果', '文尾', '附录']
    var urls = ['#context-head', '#context-participants', '#context-records', '#context-situation',
        '#context-analysis', '#context-result', '#context-tail', '#context-appendix']
    if(content === null || content === '')
        return null;
    return <span onClick={()=>scrollTo(urls[n])}>{titles[n]}</span>
}

var CaseInfo = function(props) {
    var info = props.caseInfo;
    var caseId = props.caseId;

    return <div className="main-page">
        <div className="anchor">
            <span onClick={()=>scrollTo('#general-info')}>概况</span>
            <span onClick={()=>scrollTo('#case-context')}>原文</span>
            <div className="anchor-sub">
                {subAnchorTag(info.context.head, 0)}
                {subAnchorTag(info.context.participants, 1)}
                {subAnchorTag(info.context.records, 2)}
                {subAnchorTag(info.context.situation, 3)}
                {subAnchorTag(info.context.analysis, 4)}
                {subAnchorTag(info.context.result, 5)}
                {subAnchorTag(info.context.tail, 6)}
                {subAnchorTag(info.context.appendix, 7)}
            </div>
            <span onClick={()=>scrollTo('#rec-case')}>类案推荐</span>
        </div>
        <div className="main-info-content" id="main">
            <div className="case-head">
                <span>{info.title}</span>
                <span>{info.subTitle}</span>
            </div>
            <div className="info-back-link">
                <Link to="/upload">返回文件上传</Link>
            </div>
            <GeneralInfo caseId={caseId}/>
            <CaseContext caseId={caseId}/>
            <RecCase caseId={caseId}/>
        </div>
        <div>
            <BackTop />
        </div>
    </div>;
}

module.exports = CaseInfo;