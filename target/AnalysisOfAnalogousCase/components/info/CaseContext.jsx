var React = require('react')

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
        <div className="general-info-title">
            原文
        </div>
        <div className="context-content">
            {generateContext(info.context.head, 0)}<br/>
            {generateContext(info.context.participants, 1)}<br/>
            {generateContext(info.context.records, 2)}<br/>
            {generateContext(info.context.situation, 3)}<br/>
            {generateContext(info.context.analysis, 4)}<br/>
            {generateContext(info.context.result, 5)}<br/>
            {generateContext(info.context.tail, 6)}<br/>
            {generateContext(info.context.appendix, 7)}
        </div>
    </div>;
}

module.exports = CaseContext;