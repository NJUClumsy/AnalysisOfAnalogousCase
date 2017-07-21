var React = require('react')
import { Icon } from 'antd';


var UploadFile = function(props) {

    var hint = '点击或拖拽文件至上传框内，支持标准格式的XML法案文件';

    return <div className="upload-main">
        <div className="upload-area" id="upload-area">
            <div className="upload-content">
                <div className="iconArea">
                    <Icon type="inbox" />
                </div>
                <div className="upload-text">法案文件上传</div>
                <div className="upload-hint">{props.uploadHint}</div>
            </div>
            <input type="file" id="upload" name="upload" /> <br />
        </div>
        <div className="upload-button">
            <button onClick={props.onClick}>确认上传</button>
        </div>
    </div>;
}

module.exports = UploadFile;