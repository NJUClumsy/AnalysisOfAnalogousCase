var React = require('react');
var Header = require('./Header');
import { browserHistory } from 'react-router';

var HeaderController = React.createClass({

    handleSignOut: function() {
        localStorage.removeItem('userId');
        localStorage.removeItem('username');
        browserHistory.push('/#/login');
        window.location.reload();
    },

    render: function() {
        return <Header
            handleSignOut={this.handleSignOut}
        />;
    }

});

module.exports = HeaderController;