var React = require('react');
var ReactDOM = require('react-dom');
import { Form, Icon, Input, Button, Checkbox } from 'antd';
const FormItem = Form.Item;

class NormalLoginForm extends React.Component {
    handleSubmit(e){
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            }
        });
    }
    render() {
        const { getFieldDecorator } = this.props.form;
        var isLogin = props.isLogin;
        var description = isLogin? '登录您的账户' : '注册您的账户';
        var passHtml = isLogin? null : <div className="form-row">
                <span className="form-username from-text">确认密码</span>
                <input id="password2" type="password"/>
            </div>;
        var changeDes = isLogin? '还没有账户？' : '已经有账户？';
        var changeTag = isLogin? '注册' : '登录';
        var buttonText = isLogin? '登录' : '注册';

        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <div className="login-form-header">
                    <span className="form-description from-text">{description}</span>
                </div>
                <FormItem>
                    {getFieldDecorator('userName', {
                        rules: [{ required: true, message: 'Please input your username!' }],
                    })(
                        <Input prefix={<Icon type="user" style={{ fontSize: 13 }} />} placeholder="Username" />
                    )}
                </FormItem>
                <FormItem>
                    {getFieldDecorator('password', {
                        rules: [{ required: true, message: 'Please input your Password!' }],
                    })(
                        <Input prefix={<Icon type="lock" style={{ fontSize: 13 }} />} type="password" placeholder="Password" />
                    )}
                </FormItem>
                <FormItem>
                    {getFieldDecorator('remember', {
                        valuePropName: 'checked',
                        initialValue: true,
                    })(
                        <Checkbox>Remember me</Checkbox>
                    )}
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        Log in
                    </Button>
                </FormItem>
            </Form>
        );
    }
}

<div className="login-form">
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
    <div className="test1">
        <Form/>
    </div>
    {/*<DatePicker/>*/}
</div>;

const WrappedNormalLoginForm = Form.create()(NormalLoginForm);

module.exports = WrappedNormalLoginForm;