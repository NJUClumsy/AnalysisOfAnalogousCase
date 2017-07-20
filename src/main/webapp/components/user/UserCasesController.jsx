var React = require('react');
var UserCases = require('./UserCases');
var ListStore = require('../../stores/ListStore');

var UserCasesController = React.createClass({
    getInitialState: function () {
        return {
            userCases: ListStore.getUserCases2()
        };
    },

    render: function() {
        return <UserCases
            cases={this.state.userCases}
        />;
    }

});

module.exports = UserCasesController;