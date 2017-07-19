var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
import $ from 'jquery';
import { message} from 'antd';
import { browserHistory } from 'react-router';

var server_url = 'http://172.26.22.244:8070/'


var ListStore = assign({}, EventEmitter.prototype, {
    items: [],
    isLogin: true,
    caseInfo: {},
    userId: '',
    caseId: '',

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

    getCaseInfo: function (id) {
        this.caseId = id;
        $.ajax({
            async: false,
            type : "GET",
            url : server_url + 'case/obtainById/' + id,
            data: {},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                switch (xhr.status) {
                    case 200:
                        this.caseInfo = data;
                        break;
                    default:
                        message.info('未知错误，读取文件信息失败');
                        browserHistory.push('/#/upload');
                        setTimeout("window.location.reload();", 800);
                        break;
                }
            }.bind(this),
            error: function(jqXHR, textStatus, errorThrown) {
                switch (jqXHR.status) {
                    case 404:
                        message.info('读取文件信息失败，该文件不存在');
                        break;
                    default:
                        message.info('读取文件信息失败，请检查网络连接或重新尝试');
                        break;
                }
                browserHistory.push('/#/upload');
                setTimeout("window.location.reload();", 800);
            }
        });

        return this.caseInfo;
    },

    userlLogin: function (username, password) {
        $.ajax({
            async: false,
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            type : 'POST',
            url : server_url + 'user/login',
            data: {username : username, password : password},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                switch (xhr.status) {
                    case 200:
                        this.userId = data;
                        localStorage.setItem('userId', this.userId);
                        browserHistory.push('/#/upload');
                        message.info('登录成功');
                        setTimeout("window.location.reload();", 800);
                        break;
                    default:
                        message.info('未知错误，请重新登录');
                        break;
                }
            }.bind(this),

            error: function(jqXHR, textStatus, errorThrown) {
                switch (jqXHR.status) {
                    case 401:
                        message.info('登录失败，用户名或密码错误');
                        break;
                    default:
                        message.info('登录失败，请检查网络连接或重新尝试');
                        break;
                }
            }
        });

    },

    userSignup: function (username, password) {

        $.ajax({
            async: false,
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            type : 'POST',
            url : server_url + 'user/signUp',
            data: {username: username, password: password},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                switch (xhr.status) {
                    case 201:
                        this.userId = data;
                        localStorage.setItem('userId', this.userId);
                        browserHistory.push('/#/upload');
                        message.info('注册成功');
                        setTimeout("window.location.reload();", 800 );
                        break;
                    default:
                        message.info('未知错误，请重新注册');
                        break;
                }
            }.bind(this),

            error: function(jqXHR, textStatus, errorThrown) {
                switch (jqXHR.status) {
                    case 409:
                        message.info('注册失败，用户名已被占用');
                        break;
                    default:
                        message.info('注册失败，请检查网络连接或重新尝试');
                        break;
                }
            }
        });

    },

    getUserCases: function () {

    },

    getRecCases: function () {

    },

    fileUpload: function () {

    }
});

module.exports = ListStore;
