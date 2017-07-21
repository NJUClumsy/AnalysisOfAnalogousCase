var React = require('react');
var UploadFile = require('./UploadFile');
import { browserHistory } from 'react-router';
import ListStore from '../../stores/ListStore';

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

    componentDidMount: function() {
        document.getElementById('upload-area').addEventListener("dragover", function(e) {
            e.stopPropagation();
            e.preventDefault();            // 必须调用。否则浏览器会进行默认处理，比如文本类型的文件直接打开，非文本的可能弹出一个下载文件框。
        }, false);

        document.getElementById('upload-area').addEventListener("drop", function(e) {
            e.stopPropagation();
            e.preventDefault();
            ListStore.fileUpload2(e.dataTransfer.files);
        }, false);
    },

    handleUpload: function () {
        ListStore.fileUpload();
    },

    handleDragFile: function() {
        ListStore.fileUpload2();
    },

    render: function() {
        return <UploadFile
            uploadHint={this.state.uploadHint}
            onClick={this.handleUpload}
            handleDrag={this.handleDragFile}
        />;
    }

});

module.exports = UploadController;