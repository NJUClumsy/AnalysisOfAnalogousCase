var React = require('react');
var LoginForm = require('./LoginForm');
var ListStore = require('../../stores/ListStore');
var ButtonActions = require('../../actions/ButtonActions');
import { browserHistory } from 'react-router';
var ListStore = require('../../stores/ListStore');

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

    handleSubmit: function (event){
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            }
        });
    },

    jumpToUpload: function () {
        console.log(111)
        // ListStore.userlLogin('666', '666666');
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;
        console.log(username)
        console.log(password)
        // browserHistory.push('/#/upload');
        // window.location.reload();
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