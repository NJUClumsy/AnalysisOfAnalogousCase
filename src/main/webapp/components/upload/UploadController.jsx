var React = require('react');
var UploadFile = require('./UploadFile');
import { browserHistory } from 'react-router';

var UploadController = React.createClass({

    jumpToCaseInfo: function () {
        browserHistory.push({pathname: 'case/' + '596b2dbc39e14e6ddb1bb09b'});
        window.location.reload();
    },

    render: function() {
        return <UploadFile/>;
    }

});

module.exports = UploadController;