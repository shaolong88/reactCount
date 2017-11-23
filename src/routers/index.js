import React, { Component } from 'react';
import { createStore} from 'redux'
import { Provider } from 'react-redux'
import {BrowserRouter } from 'react-router-dom';
import { Router, Route, } from 'react-router'


import reducers from '../reducers/index.js'
import  App from '../components/App.js'
import  Home from '../components/Home.js'
import  Foo from '../components/Foo.js'
import  Bar  from '../components/Bar.js'

const store = createStore(reducers);

export default class RouterIndex extends Component {
  render() {
    return ( 
        <Provider store={store}>
          <BrowserRouter>
            <App path="/App" component={App}>
              <Route path="/App/home" component={Home} />
              <Route path="/App/foo" component={Foo} />
              <Route path="/App/bar" component={Bar} />
            </App>
          </BrowserRouter>
        </Provider>
    )
  }
}
