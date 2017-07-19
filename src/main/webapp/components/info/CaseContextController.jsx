var React = require('react');
var CaseContext = require('./CaseContext');
var ListStore = require('../../stores/ListStore');

var CaseContextController = React.createClass({
    getInitialState: function () {
        return {
            caseInfo: ListStore.getCaseInfo()
        };
    },

    render: function() {
        return <CaseContext
            caseInfo={this.state.caseInfo}
        />;
    }

});

module.exports = CaseContextController;