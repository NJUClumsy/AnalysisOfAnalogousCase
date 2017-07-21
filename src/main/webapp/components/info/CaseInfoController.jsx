var React = require('react');
var CaseInfo = require('./CaseInfo');
var ListStore = require('../../stores/ListStore');

var CaseInfoController = React.createClass({
    getInitialState: function () {
        return {
            caseInfo: ListStore.getCaseInfo(this.props.params.id)
        };
    },

    render: function() {
        return <CaseInfo
            caseInfo={this.state.caseInfo}
            caseId={this.props.params.id}
        />;
    }

});

module.exports = CaseInfoController;