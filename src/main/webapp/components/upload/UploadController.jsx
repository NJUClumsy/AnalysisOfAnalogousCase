var React = require('react');
var UploadFile = require('./UploadFile');

var UploadController = React.createClass({

    jumpToCaseInfo: function () {
        browserHistory.push('/#/case/596b2dbc39e14e6ddb1bb09b');
        window.location.reload();
    },

    render: function() {
        return <UploadFile/>;
    }

});

module.exports = UploadController;