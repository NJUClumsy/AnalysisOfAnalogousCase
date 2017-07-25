var React = require('react');
var UserCases = require('./UserCases');
var ListStore = require('../../stores/ListStore');

var UserCasesController = React.createClass({
    getInitialState: function () {
        return {
            userCases: ListStore.getUserCases()
        };
    },

    refreshPage: function () {
        window.location.reload();
        document.documentElement.scrollTop = document.body.scrollTop = 0;
    },

    render: function() {
        return <UserCases
            cases={this.state.userCases}
            refreshPage={this.refreshPage}
        />;
    }

});

module.exports = UserCasesController;