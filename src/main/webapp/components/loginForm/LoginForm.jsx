var React = require('react');

var LoginForm = function(props) {
    // import { DatePicker } from 'antd';
    var isLogin = props.isLogin;
    var description = isLogin? '登录您的账户' : '注册您的账户';
    var passHtml = isLogin? null : <div className="form-row">
            <span className="form-username from-text">确认密码</span>
            <input id="password2" type="password"/>
        </div>;
    var changeDes = isLogin? '还没有账户？' : '已经有账户？';
    var changeTag = isLogin? '注册' : '登录';
    var buttonText = isLogin? '登录' : '注册';



    return <div className="login-form">
        <div className="login-form-header">
            <span className="form-description from-text">{description}</span>
        </div>
        <div className="form-row">
            <span className="form-username from-text">用户名</span>
            <input id="username" type="text" />
        </div>
        <div className="form-row">
            <span className="form-username from-text">密码</span>
            <input id="password" type="password"/>
        </div>
        {passHtml}
        <div className="form-action">
            <div className="change-label">
                <span className="form-change-des from-text">{changeDes}</span>
                <span className="form-change-tag" onClick={props.onClickTag}>{changeTag}</span>
            </div>
            <button onClick={props.onClickButton}>{buttonText}</button>
        </div>
        {/*<DatePicker/>*/}
    </div>;
}

module.exports = LoginForm;