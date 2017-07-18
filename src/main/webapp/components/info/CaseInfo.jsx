var React = require('react')
var GeneralInfo = require('./GeneralInfoController')
var RecCase = require('./RecCaseController')
var CaseContext = require('./CaseContextController')
import { Link} from 'react-router';

var CaseInfo = function(props) {
    var info = props.caseInfo;

    console.log(info)
    return <div className="main-page">
        <div className="main-info-content">
            <div className="case-head">
                {info.context.head}
            </div>
            <div className="info-back-link">
                <Link to="/upload">返回文件上传</Link>
            </div>
            <GeneralInfo/>
            <CaseContext/>
            <RecCase/>
        </div>
    </div>;
}

module.exports = CaseInfo;