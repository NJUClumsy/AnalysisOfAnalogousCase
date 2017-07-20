var React = require('react');
var RecCase = require('./RecCase');
var ListStore = require('../../stores/ListStore');

var RecCaseController = React.createClass({
    getInitialState: function () {
        return {
            recCase: ListStore.getRecCases(this.props.caseId)
        };
    },

    render: function() {
        return <RecCase
            recCase={this.state.recCase}
        />;
    }

});

module.exports = RecCaseController;