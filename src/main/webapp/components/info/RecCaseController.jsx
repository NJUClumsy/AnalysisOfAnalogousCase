var React = require('react');
var RecCase = require('./RecCase');
var ListStore = require('../../stores/ListStore');
import { message} from 'antd';
import $ from 'jquery';

var RecCaseController = React.createClass({
    getInitialState: function () {
        return {
            recCase: null,
            isLoading: true
        };
    },

    sleep: function (numberMillis) {
        var now = new Date();
        var exitTime = now.getTime() + numberMillis;
        while (true) {
            now = new Date();
            if (now.getTime() > exitTime)
                return;
        }
    },

    componentDidMount: function () {
        var caseId = this.props.caseId;
        var that = this;
        $(document).ready(function(){
            that.setState({
                recCase: ListStore.loadRecCases(caseId),
                isLoading: false
            });
        });
    },

    refreshPage: function () {
        window.location.reload();
        document.documentElement.scrollTop = document.body.scrollTop = 0;
    },

    render: function() {
        return <RecCase
            recCase={this.state.recCase}
            refreshPage={this.refreshPage}
            isLoading={this.state.isLoading}
        />;
    }

});

module.exports = RecCaseController;