var React = require('react')
var LoginFormController = require('../loginForm/LoginFormController');
// var ButtonController = require('../MyButtonController');

var Login = function(props) {

    return <div className="login-page">
        <LoginFormController/>
    </div>;
}

module.exports = Login;