var React = require('react')
import { Upload, Icon, message } from 'antd';
import ListStore from '../../stores/ListStore'

var UploadFile = function(props) {

    var Dragger = Upload.Dragger;

    var props = {
        name: 'caseFile',
        multiple: true,
        showUploadList: false,
        action: '//jsonplaceholder.typicode.com/posts/',
        // action: 'http://172.28.188.222:8080/' + 'case/upload',
        onChange(info) {
            const status = info.file.status;
            if (status !== 'uploading') {
                console.log(info.file, info.fileList);
                console.log(info)
            }
            if (status === 'done') {
                message.success(`${info.file.name} file uploaded successfully.`);
                var elements = document.getElementsByTagName("input");
                ListStore.fileUpload(elements[0]);
            } else if (status === 'error') {
                message.error(`${info.file.name} file upload failed.`);
            }
        },
    };

    return <div className="upload-main">
        <Dragger {...props} id="file-upload">
            <p className="ant-upload-drag-icon">
                <Icon type="inbox" />
            </p>
            <p className="ant-upload-text">法案文件上传</p>
            <p className="ant-upload-hint">点击或拖拽文件至上传框内，支持标准格式的XML法案文件</p>
        </Dragger>
    </div>;
}

module.exports = UploadFile;