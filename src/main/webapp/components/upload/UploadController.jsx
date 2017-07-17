var React = require('react');
var UploadFile = require('./UploadFile');

var UploadController = React.createClass({

    render: function() {
        return <UploadFile/>;
    }

});

module.exports = UploadController;