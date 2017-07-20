var React = require('react')

var RecCase = function(props) {
    var info = props.recCase;
    var innerHtml;
    if (info === null || info === [])
        innerHtml = <div style={{color: '#AAAAAA'}}>暂无信息</div>
    else
        innerHtml = info.map(function (item, i) {
            return <div key={i}>{i+1}.{item.caseNumber} </div>;
        });

    return <div className="rec-case info-head"id="rec-case">
        <div className="general-info-title">
            关联案件推荐
        </div>
        <div className="rec-content">
            {innerHtml}
        </div>
    </div>;
}

module.exports = RecCase;