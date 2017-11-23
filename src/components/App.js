import React, { Component } from 'react';
import { Link, BrowserRouter,withRouter, } from 'react-router-dom';
import PropTypes from "prop-types";
import PubSub from 'pubsub-js'

export default class App extends Component{
  static contextTypes = {
    router: PropTypes.object
  }
constructor(props,context){
  super(props,context);
  this.state={
    increase:'none',
  }
}

componentDidMount(){
  this.pubsub_token = PubSub.subscribe('products', function (topic,products) {
    this.setState({
      increase: products
    });
  }.bind(this));
}
componentWillUnmount(){
  PubSub.unsubscribe(this.pubsub_token);
}
  render() {
  return (
    <div>
      <header>
        Links:
        {' '}
        <Link to="/App/home">Home</Link>
        {' '}
        <Link to="/App/foo">Foo</Link>
        {' '}
        <Link to="/App/bar">Bar</Link>
      </header>
      <div>
        <button onClick={() =>{
          this.context.router.history.push("/App/foo");
          }}>Go to /App/foo</button>
      </div>
      <div style={{ marginTop: '1.5em' }}>{ this.props.children}</div>
      <div style={{ marginTop: '1.5em' }}>{ this.state.increase}</div>
    </div>
  )
}
}