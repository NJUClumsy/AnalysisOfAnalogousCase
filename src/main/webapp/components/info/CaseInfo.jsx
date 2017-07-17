var React = require('react')
var GeneralInfo = require('./GeneralInfoController')
var RecCase = require('./RecCaseController')
var CaseContext = require('./CaseContextController')
import { Link} from 'react-router';

var CaseInfo = function(props) {

    return <div className="main-page">
        <div className="main-info-content">
            <div className="case-head">
                刘洋与国家工商行政管理总局商标评审委员会、万金刚商标异议复审行政纠纷再审审查行政裁定书 （2008）丽民初字第3531号
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