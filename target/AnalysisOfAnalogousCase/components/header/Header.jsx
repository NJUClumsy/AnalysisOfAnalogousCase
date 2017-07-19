var React = require('react')

var Header = function(props) {

    return <div className="header">
        <div className="header-logo">
            <img src="img/logo.png" height="60" width="60" alt=""/>
        </div>
        <div className="header-title">
            <span className="header-group">Clumsy</span>
            <span className="header-artifact">Analysis of Analogous Case</span>
        </div>
    </div>;
}

module.exports = Header;