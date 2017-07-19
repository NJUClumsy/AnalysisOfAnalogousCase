var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
import $ from 'jquery';

var server_url = 'http://172.28.188.222:8080/'


var ListStore = assign({}, EventEmitter.prototype, {
    items: [],
    isLogin: true,
    caseInfo: {},
    username: '',
    userId: '',

    getAll: function () {
        return this.items;
    },

    addNewItemHandler: function (text) {
        this.items.push(text);
    },

    emitChange: function () {
        this.emit('change');
    },

    addChangeListener: function(callback) {
        this.on('change', callback);
    },

    removeChangeListener: function(callback) {
        this.removeListener('change', callback);
    },

    getIsLogin: function () {
        return this.isLogin;
    },

    changeFormHandler: function () {
        this.isLogin = !this.isLogin;
    },

    getCaseInfo: function () {
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
    },

    userlLogin: function (username, password) {

        $.ajax({
            async: false,
            contentType: 'application/json; charset=utf-8',
            type : 'POST',
            url : server_url + 'user/login',
            data: JSON.stringify({
                name: username,
                password: password
            }),
            datatype : 'json',
            success : function(data) {
                alert("操作成功");
            }.bind(this),

            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });

    },

    userSignup: function () {

    },

    getUserCases: function () {

    },

    getRecCases: function () {

    },

    fileUpload: function () {

    }
});

module.exports = ListStore;
