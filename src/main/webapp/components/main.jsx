import React from 'react'
import HeaderController from './header/HeaderController';
import { browserHistory } from 'react-router';

export default class Main extends React.Component{

    constructor(props){
        super(props);
    }

    render() {
        return (
            <div className="main-div">
                <div className="main-header">
                    <HeaderController/>
                </div>
                <div className="content-div">
                    {this.props.children}
                </div>
            </div>
        );
    }
}

module.exports = Main;
