var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
import $ from 'jquery';

var ListStore = assign({}, EventEmitter.prototype, {
  items: [],
  isLogin: true,
    caseInfo: {},

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

module.exports = ListStore;
