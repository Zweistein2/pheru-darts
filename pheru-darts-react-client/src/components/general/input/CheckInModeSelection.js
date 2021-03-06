import React from 'react'
import PropTypes from "prop-types";
import {ALL_CHECKIN_MODES} from "../../../constants/checkinModes";
import KeyTextToggleButtonGroup from "./KeyTextToggleButtonGroup";

class CheckInModeSelection extends React.Component {

    render() {
        return <KeyTextToggleButtonGroup {...this.props} options={ALL_CHECKIN_MODES} />
    }
}

CheckInModeSelection.propTypes = {
    value: PropTypes.oneOfType([
        PropTypes.object,
        PropTypes.array
    ]),
    onChange: PropTypes.func,
    borderRightZero: PropTypes.bool,
    multipleSelect: PropTypes.bool
};

export default CheckInModeSelection