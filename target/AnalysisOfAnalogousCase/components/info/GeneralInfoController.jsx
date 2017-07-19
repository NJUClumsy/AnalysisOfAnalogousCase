var React = require('react');
var GeneralInfo = require('./GeneralInfo');
var ListStore = require('../../stores/ListStore');

var GeneralInfoController = React.createClass({
    getInitialState: function () {
        return {
            caseInfo: ListStore.getInfo()
        };
    },

    render: function() {
        return <GeneralInfo
            caseInfo={this.state.caseInfo}
        />;
    }

});

module.exports = GeneralInfoController;