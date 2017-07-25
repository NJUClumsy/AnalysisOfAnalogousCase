var React = require('react');
var UploadFile = require('./UploadFile');
import { browserHistory } from 'react-router';
import ListStore from '../../stores/ListStore';
var ButtonActions = require('../../actions/ButtonActions');

var UploadController = React.createClass({
    getInitialState: function () {
        return {
            uploadHint: ListStore.getUploadHint()
        };
    },

    jumpToCaseInfo: function () {
        browserHistory.push({pathname: 'case/' + '596b2dbc39e14e6ddb1bb09b'});
        window.location.reload();
    },

    componentWillUnmount: function() {
        ListStore.removeChangeListener(this._onChange);
    },

    _onChange: function () {
        this.setState({
            uploadHint: ListStore.getUploadHint()
        });
    },

    componentDidMount: function() {
        ListStore.addChangeListener(this._onChange);
        document.getElementById('upload-area').addEventListener("dragover", function(e) {
            e.stopPropagation();
            e.preventDefault();            // 必须调用。否则浏览器会进行默认处理，比如文本类型的文件直接打开，非文本的可能弹出一个下载文件框。
        }, false);

        document.getElementById('upload-area').addEventListener("drop", function(e) {
            e.stopPropagation();
            e.preventDefault();
            if(e.dataTransfer.files.length === 1) {
                ListStore.saveUploadFile(e.dataTransfer.files[0]);
                ButtonActions.displayFileName(e.dataTransfer.files[0].name);
            }
        }, false);
    },

    handleUpload: function () {
        ListStore.fileUpload();
    },

    saveUploadFile: function() {
        if(document.getElementById('upload').files[0]) {
            var file = document.getElementById('upload').files[0];
            ButtonActions.displayFileName(file.name);
            ListStore.saveUploadFile(file);
            console.log(file.name);
        }
    },

    render: function() {
        return <UploadFile
            uploadHint={this.state.uploadHint}
            onClick={this.handleUpload}
            changeFileName={this.saveUploadFile}
        />;
    }

});

module.exports = UploadController;