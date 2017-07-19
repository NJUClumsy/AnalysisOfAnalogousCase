var React = require('react');
var Homepage = require('./Homepage');
import { browserHistory } from 'react-router';

var LoginFormController = React.createClass({
    contextTypes: {
        router: React.PropTypes.object
    },

    jumpToInfo: function () {
        browserHistory.push('/#/case');
        window.location.reload();
    },

    render: function() {
        return <Homepage
            onClick={this.jumpToInfo}
        />;
    }

});

module.exports = LoginFormController;