var React = require('react')
var UploadController = require('../upload/UploadController');

var Homepage = function(props) {

    return <div className="main-page">
        <div className="main-content">
            <UploadController/>
        </div>
    </div>;
}

module.exports = Homepage;