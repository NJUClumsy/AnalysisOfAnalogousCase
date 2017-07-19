var React = require('react');
import Form from '../antd/Form'

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



    return <div className="test1">
        <Form isLogin={this.state.isLogin}
              onClickTag={this.changeForm}
              onClickButton={this.jumpToUpload}
              test = {this.handleSubmit}
        />
    </div>;
}

module.exports = LoginForm;