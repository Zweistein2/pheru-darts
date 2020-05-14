import React from 'react'
import {Line, LineChart, CartesianGrid, Legend, ResponsiveContainer, Tooltip, XAxis, YAxis} from "recharts";
import PropTypes from "prop-types";

class AverageLineChart extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {
        return <ResponsiveContainer width="100%" height={300}>
            <LineChart data={this.props.data}>
                <CartesianGrid vertical={false}/>
                <XAxis dataKey="aufnahme"/>
                <YAxis/>
                <Tooltip labelFormatter={() => ""}/>
                <Legend/>
                <Line type="monotone" name="Average" dataKey="average" fillOpacity={0.8} fill="#08965f"/>
            </LineChart>
        </ResponsiveContainer>
    }
}

AverageLineChart.propTypes = {
    data : PropTypes.array.isRequired
};

export default AverageLineChart;