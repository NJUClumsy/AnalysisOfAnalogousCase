var React = require('react');
import { Link } from 'react-router';
import { Spin } from 'antd';

var RecCase = function(props) {

    var info = props.recCase;
    var innerHtml;
    if (info === null || info.length === 0) {
        innerHtml = <div style={{color: '#AAAAAA'}}>暂无信息</div>;
    }
    else
        innerHtml = info.map(function (item, i) {
            var innerString = item.caseNumber.replace(/\(/i, "（");
            innerString = innerString.replace(/\)/i, "）");
            return <div key={i} >
                <Link to={{ pathname: '/case/' + item.caseId}} onClick={props.refreshPage}>{i+1}.{innerString}</Link>
            </div>;
        });

    return <div className="rec-case info-head"id="rec-case">
        <Spin tip="Loading..." spinning={props.isLoading}>
            <div className="general-info-title">
                相似案件推荐
            </div>
            <div className="rec-content">
                {innerHtml}
            </div>
        </Spin>
    </div>;
}

module.exports = RecCase;