var React = require('react')
var HeaderController = require('../header/HeaderController');
var LoginFormController = require('../loginForm/LoginFormController');
// var ButtonController = require('../MyButtonController');

var Login = function(props) {

    return <div className="login-page">
        <HeaderController/>
        <LoginFormController/>
        {/*<ButtonController/>*/}
    </div>;
}

module.exports = Login;