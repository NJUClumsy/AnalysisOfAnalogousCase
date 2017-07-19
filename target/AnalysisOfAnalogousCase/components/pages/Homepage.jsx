var React = require('react')
var UploadController = require('../upload/UploadController');
import HeaderController from '../header/HeaderController';

var Homepage = function(props) {

    return <div className="main-page">
        <div className="main-header">
            <HeaderController/>
        </div>
        <div className="main-content">
            <UploadController/>
            <div className="test">
                <button onClick={props.onClick}>sadasdsad</button>
            </div>
        </div>
    </div>;
}

module.exports = Homepage;