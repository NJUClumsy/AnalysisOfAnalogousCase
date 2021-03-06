var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
import $ from 'jquery';
import { message} from 'antd';
import { browserHistory } from 'react-router';

var server_url = 'http://localhost:8080/';


var ListStore = assign({}, EventEmitter.prototype, {
    items: [],
    isLogin: true,
    caseInfo: {},
    userId: '',
    caseId: '',
    recCase: [],
    userCases: [],
    uploadHint: '',
    uploadFile: null,
    serverUrl: 'http://localhost:8070/',

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

    saveUploadFile: function (file) {
        this.uploadFile = file;
    },

    displayFileName: function(text) {
        this.uploadHint = text;
    },

    getUploadHint:function () {
        if(this.uploadHint === '')
            this.uploadHint = '点击或拖拽文件至上传框内，支持标准格式的XML法案文件';
        return this.uploadHint;
    },

    getCaseInfo: function (id) {
        this.caseId = id;
        $.ajax({
            async: false,
            type : 'GET',
            url : server_url + 'case/obtainById/' + id,
            // url: './data.json',
            data: {},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                switch (xhr.status) {
                    case 200:
                        this.caseInfo = data;
                        break;
                    default:
                        message.info('未知错误，读取文件信息失败');
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
                        localStorage.setItem('username', username);
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
                        localStorage.setItem('username', username);
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
        $.ajax({
            async: false,
            type : 'GET',
            url : server_url + 'user/cases/' + localStorage.getItem('userId'),
            data: {},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                switch (xhr.status) {
                    case 200:
                        this.userCases = data;
                        break;
                    case 204:
                        this.userCases = [];
                        break;
                    default:
                        this.userCases = null;
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
            }
        });
        return this.userCases;
    },

    getUserCases2: function () {
        $.ajax({
            async: false,
            type : 'GET',
            url : server_url + 'user/cases/' + localStorage.getItem('userId'), // 596dae010eb65b90fcbe482b
            // url : '../data2.json',
            data: {},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                this.userCases = data.userCases;
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
            }
        });
        return this.userCases;
    },

    getRecCases: function () {
      return this.recCase;
    },

    loadRecCases: function (id) {
        this.caseId = id;
        $.ajax({
            async: false,
            type : 'GET',
            url : server_url + 'similar/recommend/' + id,
            // url: './data2.json',
            data: {},
            datatype : 'json',
            success : function(data, textStatus, xhr) {
                switch (xhr.status) {
                    case 200:
                        this.recCase = data;
                        break;
                    case 204:
                        this.recCase = [];
                        break;
                    default:
                        message.info('未知错误，读取类案推荐失败');
                        break;
                }
            }.bind(this),
            error: function(jqXHR, textStatus, errorThrown) {
                switch (jqXHR.status) {
                    case 404:
                        message.info('读取类案推荐失败，请刷新尝试');
                        break;
                    default:
                        message.info('读取类案推荐失败，请检查网络连接或重新尝试');
                        break;
                }
            }
        });
        return this.recCase;
    },

    fileUpload: function () {
        if(this.uploadFile === null){
            message.info('请先选择您要上传的文件');
        }else {
            if (window.FormData) {
                var formData = new FormData();

                formData.append('caseFile', this.uploadFile);
                formData.append('id', localStorage.getItem('userId'));

                $.ajax({
                    async: false,
                    contentType: false,
                    processData: false,
                    cache: false,
                    type: 'POST',
                    url: server_url + 'case/upload',
                    data: formData,
                    success: function (data, textStatus, xhr) {
                        switch (xhr.status) {
                            case 200:
                                this.caseId = data;
                                browserHistory.push({pathname: '/#/case/' + this.caseId});
                                message.info('已成功匹配到文书数据');
                                setTimeout("window.location.reload();", 800);
                                break;
                            case 201:
                                this.caseId = data;
                                browserHistory.push({pathname: '/#/case/' + this.caseId});
                                message.info('正在生成文书数据');
                                setTimeout("window.location.reload();", 800);
                                break;
                            default:
                                message.info('您上传的是空文件，无法解析');
                                break;
                        }
                    }.bind(this),

                    error: function (jqXHR, textStatus, errorThrown) {
                        message.info('文件格式出错，请选择符合规范的文件上传');
                    }
                });
            }
        }
    }
});

module.exports = ListStore;
