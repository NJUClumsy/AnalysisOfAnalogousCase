var React = require('react');
var Homepage = require('./Homepage');

var LoginFormController = React.createClass({
    contextTypes: {
        router: React.PropTypes.object
    },

    render: function() {
        return <Homepage/>;
    }
});

module.exports = LoginFormController;