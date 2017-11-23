import React, { Component } from 'react';
import { connect } from 'react-redux'
import PubSub from 'pubsub-js'
class Home extends Component {
  constructor(props){
    super(props);
    this.state={
      increase:'increase',
      decrease:'decrease'
    }
  }
  buttonIncrease(){
    const { setIncrease} = this.props;
    setIncrease({
      type: 'INCREASE',
      payload: 1
    });
    console.log('this.state.increase');
    console.log(this.state.increase);
    PubSub.publish('products',this.state.increase);
  }
  buttonDecrease(){
    const { setDecrease} = this.props;
    setDecrease({
      type: 'DECREASE',
      payload: 1
    });

    PubSub.publish('products', this.state.decrease);
  }
  render() {
    const { number,setDecrease } = this.props;
    return (
      <div>
        Some state changes:
        {this.props.number}
        <button onClick={this.buttonIncrease.bind(this)}>Increase</button>
        <button onClick={this.buttonDecrease.bind(this)}>Decrease</button>
      </div>
    )
  }
}
function mapStateToProps(state) {
  return {
    number: state.count.number
  }
}
function mapDispatchToProps(dispatch) {
  return {
    setIncrease: (state) => dispatch(state),
    setDecrease: (state) => dispatch(state)
  }
}
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Home)
// import EventEmitter from 'eventemitter3';
// const myEmitter=new EventEmitter();
// myEmitter.on('event', () => {
//   console.log('an event occurred!');
//   this.state.increase;
// });
// myEmitter.emit('event');
// console.log(myEmitter);