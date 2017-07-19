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

<<<<<<< HEAD
=======
    // anchorJump: function () {
    //     console.log(11)
    //     var anchorName = '#rec-case'
    //     if (anchorName) {
    //         var anchorElement = document.getElementById(anchorName);
    //         if(anchorElement) { anchorElement.scrollIntoView(); }
    //     }
    // },

>>>>>>> b9db0c393e76fd8f6e621a6974b7f99df76d85e4
    render: function() {
        return <CaseInfo
            caseInfo={this.state.caseInfo}
        />;
    }

});

module.exports = CaseInfoController;