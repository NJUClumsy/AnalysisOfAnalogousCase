var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
import $ from 'jquery';

var CaseInfoStore = assign({}, EventEmitter.prototype, {
    caseInfo: {},

    getInfo: function () {
        $.ajax({
            async: false,
            type : "get",
            url : "../data.json",
            data: {},
            datatype : 'json',

            success : function(data,textStatus) {
                this.caseInfo = data;
            }.bind(this),

            error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR.status + ' ' + jqXHR.responseText);
            }

        });
        return this.caseInfo;
    }
});

module.exports = CaseInfoStore;
