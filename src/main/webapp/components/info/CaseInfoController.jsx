var React = require('react');
var CaseInfo = require('./CaseInfo');
var ListStore = require('../../stores/ListStore');

var CaseInfoController = React.createClass({
    getInitialState: function () {
        return {
            caseInfo: ListStore.getCaseInfo()
        };
    },

    _onChange: function () {
        this.setState({
            items: ListStore.getCaseInfo()
        });
    },

    render: function() {
        return <CaseInfo
            caseInfo={this.state.caseInfo}
        />;
    }

});

module.exports = CaseInfoController;