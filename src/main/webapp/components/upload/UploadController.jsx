var React = require('react');
var UploadFile = require('./UploadFile');
import { browserHistory } from 'react-router';
import ListStore from '../../stores/ListStore';

var UploadController = React.createClass({

    jumpToCaseInfo: function () {
        browserHistory.push({pathname: 'case/' + '596b2dbc39e14e6ddb1bb09b'});
        window.location.reload();
    },

    handleUpload: function () {
        ListStore.fileUpload();
    },

    render: function() {
        return <UploadFile
            onClick={this.handleUpload}
        />;
    }

});

module.exports = UploadController;