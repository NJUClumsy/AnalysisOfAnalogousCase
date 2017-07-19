var React = require('react');
var ReactDOM = require('react-dom');
var LoginController = require('./components/pages/LoginController');
var HomepageController = require('./components/pages/HomepageController');
var CaseInfoController = require('./components/info/CaseInfoController')
var Main = require('./components/main')
import { Router, Route, Link, hashHistory, browserHistory, IndexRoute } from 'react-router';


ReactDOM.render(
    (<Router history={hashHistory}>
        <Route path="/" component={Main}>
            <IndexRoute component={LoginController} />
            <Route path="login" component={LoginController} />
            <Route path="upload" component={HomepageController} />
            <Route path="case/:id" component={CaseInfoController} />
        </Route>
    </Router>),
    document.querySelector('#app')
);
