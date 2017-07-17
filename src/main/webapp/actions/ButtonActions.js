var AppDispatcher = require('../dispatcher/AppDispatcher');

var ButtonActions = {

  addNewItem: function (text) {
      AppDispatcher.dispatch({
          actionType: 'ADD_NEW_ITEM',
          text: text
      });
  },
  changeForm: function () {
      AppDispatcher.dispatch({
          actionType: 'CHANGE_FORM'
      });
  }

};

module.exports = ButtonActions;
