import React, { Component } from 'react';
import { connect } from 'react-redux'

class Home extends Component {
  render() {
    const { number, setIncrease, setDecrease } = this.props;
    console.log('this.props.number');
    console.log(this.props.number);
    return (
      <div>
        Some state changes:
      {this.props.number}
        <button onClick={() =>
          setIncrease({
            type: 'INCREASE',
            payload: 1
          })}>
          Increase</button>
        <button onClick={() => 
         setDecrease({
          type: 'DECREASE',
          payload: 1
        })}>Decrease</button>
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
