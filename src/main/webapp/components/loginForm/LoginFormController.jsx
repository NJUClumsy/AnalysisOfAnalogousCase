var React = require('react');
var LoginForm = require('./LoginForm');
var ListStore = require('../../stores/ListStore');
var ButtonActions = require('../../actions/ButtonActions');

var LoginFormController = React.createClass({
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

    render: function() {
        return <LoginForm
            isLogin={this.state.isLogin}
            onClick={this.changeForm}
        />;
    }

});

module.exports = LoginFormController;