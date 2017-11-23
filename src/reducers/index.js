import { combineReducers } from 'redux'
const initialState={
    number:2
};
function update(state = initialState, action) {
    switch (action.type) {
        case 'INCREASE':
            // console.log("INCREASE");
            // console.log(state);
            return {
                number: state.number+action.payload 
            };
        case 'DECREASE':
            // console.log("DECREASE");
            // console.log(state);
            return {
                number:state.number- action.payload  
            };
        default:
            return state;
    }
}
export default combineReducers({
    count: update,
})