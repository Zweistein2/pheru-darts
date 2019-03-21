import React from 'react'
import {Alert, Glyphicon, Table, ToggleButton, ToggleButtonGroup, Well} from "react-bootstrap";
import GamesBarChart from "./GamesBarChart";
import DartsBarChart from "./DartsBarChart";
import PropTypes from "prop-types";
import StackLoader from "../../general/loaders/StackLoader";
import DartsRadarChart from "./DartsRadarChart";
import OnlyForLoggedInUsersContainer from "../../../containers/general/OnlyForLoggedInUsersContainer";
import DocumentUtil from "../../../util/DocumentUtil";
import StatisticsFilter from "./StatisticsFilter";

const TITLE = "Statistiken";

const DART_CHART_TYPE_BAR = "bar";
const DART_CHART_TYPE_RADAR = "radar";

class Statistics extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            dartChartType: DART_CHART_TYPE_BAR
        };
        this.tableStyle = {
            border: "1px solid #a5b0b6",
            borderCollapse: "collapse",
            textAlign: "center",
            verticalAlign: "middle"
        };
        this.dartsBarChartRef = React.createRef();
        this.dartsRadarChartRef = React.createRef();
        this.handleDartChartTypeChange = this.handleDartChartTypeChange.bind(this);
    }

    componentDidMount() {
        DocumentUtil.setTitlePrefix(TITLE);
        if (this.props.isLoggedIn) {
            this.props.fetchStatisticsFilterOptions();
            this.props.fetchStatistics();
        }
    }

    componentDidUpdate(prevProps) {
        if (!prevProps.isLoggedIn && this.props.isLoggedIn) {
            this.props.fetchStatisticsFilterOptions();
            this.props.fetchStatistics();
        }
    }

    handleDartChartTypeChange(e) {
        this.setState({dartChartType: e},
            () => {
                // Ohne Timeout funktioniert das smooth-scrollen nicht,
                // liegt wahrscheinlich an der Chart-Komponente
                setTimeout(() => {
                    let scrollRef = this.getRefForDartChartType(e);
                    if (scrollRef && scrollRef.current) {
                        scrollRef.current.scrollIntoView({block: "end", behavior: "smooth"});
                    }
                }, 50);
            }
        );

    }

    getRefForDartChartType(type) {
        switch (type) {
            case DART_CHART_TYPE_BAR:
                return this.dartsBarChartRef;
            case DART_CHART_TYPE_RADAR:
                return this.dartsRadarChartRef;
            default:
                return null;
        }
    }

    render() {
        return <OnlyForLoggedInUsersContainer
            text="Statistiken können nur für angemeldete Benutzer erstellt und eingesehen werden">
            <div style={{textAlign: 'center'}}>
                <h1 style={{marginTop: 0}}><strong>{TITLE}</strong></h1>
                <StatisticsFilter style={{marginBottom: 5}}
                                  fetchStatistics={this.props.fetchStatistics}
                                  options={this.props.options}
                />
            </div>
            {this.props.isFetchingStatistics ?
                    <StackLoader modal label="Lade Statistiken..."/>
                : <div>
                    {this.props.dartData.length > 0
                        ? this.createDartsView()
                        : <Alert bsStyle="warning">
                            <strong>Keine Dart-Daten vorhanden</strong>
                        </Alert>}
                    {this.props.gamesData.length > 0
                        ? this.createGamesView()
                        : <Alert bsStyle="warning">
                            <strong>Keine Spiel-Daten vorhanden</strong>
                        </Alert>}
                </div>
            }
        </OnlyForLoggedInUsersContainer>
    }

    createDartsView() {
        return <Well style={{
            paddingBottom: 0,
            marginBottom: 15,
            textAlign: 'center'
        }}>
            <h2 style={{marginTop: 0}}><strong>Darts</strong></h2>
            <Table responsive style={{textAlign: 'center'}}>
                <tbody>
                <tr>
                    <th style={this.tableStyle}>Gesamt:</th>
                    <td colSpan={3} style={this.tableStyle}>{this.props.totalDarts}</td>
                </tr>
                <tr>
                    <th rowSpan={2} style={this.tableStyle}>Checkouts:</th>
                    <th style={this.tableStyle}>Mögliche Checkouts</th>
                    <th style={this.tableStyle}>Erfolgreiche Checkouts</th>
                    <th style={this.tableStyle}>Checkoutrate</th>
                </tr>
                <tr>
                    <td style={this.tableStyle}>{this.props.possibleCheckoutDarts}</td>
                    <td style={this.tableStyle}>{this.props.checkoutDarts}</td>
                    <td style={this.tableStyle}>{this.getDartCheckoutRate()}</td>
                </tr>
                </tbody>
            </Table>
            <ToggleButtonGroup type="radio" name="options" value={this.state.dartChartType}
                               onChange={this.handleDartChartTypeChange}
                               style={{marginBottom: 10}}>
                <ToggleButton value={DART_CHART_TYPE_BAR} style={{width: 100}}>
                    <Glyphicon glyph="stats"/>
                </ToggleButton>
                <ToggleButton value={DART_CHART_TYPE_RADAR} style={{width: 100}}>
                    <Glyphicon glyph="certificate"/>
                </ToggleButton>
            </ToggleButtonGroup>
            {this.state.dartChartType === DART_CHART_TYPE_BAR &&
            <div ref={this.dartsBarChartRef}>
                <DartsBarChart data={this.props.dartData}/>
            </div>
            }
            {this.state.dartChartType === DART_CHART_TYPE_RADAR &&
            <div ref={this.dartsRadarChartRef}>
                <DartsRadarChart data={this.props.dartData}/>
            </div>
            }
        </Well>
    }

    createGamesView() {
        return <Well
            style={{
                paddingBottom: 0,
                marginBottom: 15,
                textAlign: 'center'
            }}>
            <h2 style={{marginTop: 0}}><strong>Spiele</strong></h2>
            <Table responsive style={{textAlign: 'center'}}>
                <tbody>
                <tr>
                    <th style={this.tableStyle}>Gesamt</th>
                    <th style={this.tableStyle}>Gewonnen</th>
                    <th style={this.tableStyle}>Verloren</th>
                    <th style={this.tableStyle}>Siegrate</th>
                </tr>
                <tr>
                    <td style={this.tableStyle}>{this.props.gamesWon + this.props.gamesLost}</td>
                    <td style={this.tableStyle}>{this.props.gamesWon}</td>
                    <td style={this.tableStyle}>{this.props.gamesLost}</td>
                    <td style={this.tableStyle}>{this.getWinRate()}</td>
                </tr>
                </tbody>
            </Table>
            <GamesBarChart data={this.props.gamesData}/>
        </Well>
    }

    getWinRate() {
        return this.getRate(this.props.gamesWon, this.props.gamesWon + this.props.gamesLost);
    }

    getDartCheckoutRate() {
        return this.getRate(this.props.checkoutDarts, this.props.possibleCheckoutDarts);
    }

    getRate(value, possible) {
        let rate = (value / possible * 100).toFixed(2);
        return isNaN(rate) ? "-" : rate + "%";
    }

}

Statistics.propTypes = {
    isLoggedIn: PropTypes.bool.isRequired,
    isLoggingIn: PropTypes.bool.isRequired,
    isFetchingStatistics: PropTypes.bool.isRequired,
    gamesWon: PropTypes.number.isRequired,
    gamesLost: PropTypes.number.isRequired,
    totalDarts: PropTypes.number.isRequired,
    dartData: PropTypes.array,
    gamesData: PropTypes.array,

    options: PropTypes.object.isRequired,

    showLogin: PropTypes.func.isRequired,
    fetchStatistics: PropTypes.func.isRequired,
    fetchStatisticsFilterOptions: PropTypes.func.isRequired
};

export default Statistics;