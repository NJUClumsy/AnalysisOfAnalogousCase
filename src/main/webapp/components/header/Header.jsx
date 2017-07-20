var React = require('react')
import { Link } from 'react-router';

var Header = function(props) {
    var username = localStorage.getItem('username') != null ?
        <div className="user-tag">
            <span>
                <Link to={{ pathname: '/user/' + localStorage.getItem('userId')}}>
                    <span className="header-username">{localStorage.getItem('username')}</span>
                </Link>
                ，您好！</span>
            <span className="header-sign-out" onClick={props.handleSignOut}>登出</span>
        </div>: null;

    return <div className="header">
        <div className="header-logo">
            <img src="img/logo.png" height="60" width="60" alt=""/>
        </div>
        <div className="header-title">
            <span className="header-group">Clumsy</span>
            <span className="header-artifact">Analysis of Analogous Case</span>
        </div>
        {username}
    </div>;
}

module.exports = Header;