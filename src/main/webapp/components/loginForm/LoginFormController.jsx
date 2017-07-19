var React = require('react');
var LoginForm = require('./LoginForm');
var ListStore = require('../../stores/ListStore');
var ButtonActions = require('../../actions/ButtonActions');
var ListStore = require('../../stores/ListStore');
import { message, Alert } from 'antd';

var LoginFormController = React.createClass({
    contextTypes: {
        router: React.PropTypes.object
    },

    getInitialState: function () {
        return {
            isLogin: ListStore.getIsLogin()
        };
    },

    componentDidMount: function() {
        ListStore.addChangeListener(this._onChange);
    },

    componentWillUnmount: function() {
        ListStore.removeChangeListener(this._onChange);
    },

    changeForm: function (event) {
        ButtonActions.changeForm();
    },

    _onChange: function () {
        this.setState({
            isLogin: ListStore.getIsLogin()
        });
    },

    jumpToUpload: function () {
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;

        if( this.state.isLogin )
            ListStore.userlLogin(username, password);
        else {
            var pass2 = document.getElementById('password2').value;
            if (password === pass2)
                ListStore.userSignup(username, password);
            else {
                message.info('注册失败，两次输入的密码不一致');
            }
        }
    },

    render: function() {
        return <LoginForm
            isLogin={this.state.isLogin}
            onClickTag={this.changeForm}
            onClickButton={this.jumpToUpload}
            test = {this.handleSubmit}
        />;
    }

});

module.exports = LoginFormController;