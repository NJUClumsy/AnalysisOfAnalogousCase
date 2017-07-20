var React = require('react')
import { Link} from 'react-router';

var UserCases = function(props) {
    var cases = props.cases;
    var innerHtml = cases.map(function (item, i) {
        return <div key={i}>{i+1}.{item.caseNumber} </div>;
    });

    return <div className="main-page">
        <div className="user-page">
            <div className="info-back-link">
                <Link to="/upload">返回文件上传</Link>
            </div>
            <div className="user-case info-head">
                <div className="general-info-title">
                    您上传的法案文件
                </div>
                <div className="user-cases-content">
                    {innerHtml}
                </div>
            </div>
        </div>
    </div>;
}

module.exports = UserCases;