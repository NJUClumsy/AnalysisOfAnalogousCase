var React = require('react');
var Homepage = require('./Homepage');
import { browserHistory } from 'react-router';
var ListStore = require('../../stores/ListStore');

var LoginFormController = React.createClass({
    contextTypes: {
        router: React.PropTypes.object
    },

    jumpToInfo: function () {
        browserHistory.push({
            pathname: '/#/case/:id',
            state: { id: '596b2dbc39e14e6ddb1bb09b' }
        });
        window.location.reload();
    },

    render: function() {
        return <Homepage
            onClick={this.jumpToInfo}
        />;
    }

});

module.exports = LoginFormController;