import React from 'react'
import PropTypes from "prop-types";
import {ToggleButton, ToggleButtonGroup} from "react-bootstrap";

class KeyTextToggleButtonGroup extends React.Component {

    render() {
        return <ToggleButtonGroup type="radio" name="options" value={this.props.value}
                                  onChange={this.props.onChange}>
            {this.props.options.map((mode, i) =>
                <ToggleButton
                    style={(i === this.props.options.length - 1) && this.props.borderRightZero
                        ? {borderTopRightRadius: 0, borderBottomRightRadius: 0}
                        : {}}
                    key={mode.key} value={mode}>{mode.text}</ToggleButton>
            )}
        </ToggleButtonGroup>
    }
}

KeyTextToggleButtonGroup.propTypes = {
    options: PropTypes.array.isRequired,
    value: PropTypes.object,
    onChange: PropTypes.func,
    borderRightZero: PropTypes.bool
};

export default KeyTextToggleButtonGroup