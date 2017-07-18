var React = require('react');
var CaseInfo = require('./CaseInfo');
var ListStore = require('../../stores/ListStore');

var CaseInfoController = React.createClass({
    getInitialState: function () {
        return {
            caseInfo: ListStore.getInfo()
        };
    },

    _onChange: function () {
        this.setState({
            items: ListStore.getInfo()
        });
    },

    render: function() {
        return <CaseInfo
            caseInfo={this.state.caseInfo}
        />;
    }

});

module.exports = CaseInfoController;