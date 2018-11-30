import React from 'react'
import PropTypes from "prop-types";
import StackLoader from "../../general/loaders/StackLoader";
import {Alert, Badge, Button, Glyphicon, Table, Well} from "react-bootstrap";
import {toDate, toTime} from "../../../util/dateUtil";

class Notifications extends React.Component {

    render() {
        return <div>
            {this.props.isLoggedIn
                ? this.createNotification()
                : <Alert bsStyle="warning"
                         style={{marginLeft: 15, marginRight: 15, marginBottom: 5, textAlign: 'center'}}>
                    <strong>Mitteilungen können nur von angemeldeten Benutzern eingesehen werden</strong>
                    <br/>
                    <Button style={{marginTop: 10}} bsStyle="primary" onClick={this.props.showLogin}
                            disabled={this.props.isLoggingIn}>
                        <Glyphicon glyph="log-in"/> Anmelden</Button>
                </Alert>
            }
        </div>
    }

    createNotification() {
        return <Well style={{marginLeft: 20, marginRight: 20, paddingBottom: 0, textAlign: "center"}}>
            <Button bsStyle="primary" style={{marginRight: 5}}
                    onClick={this.props.fetchNotifications}
                    disabled={this.props.isFetchingNotifications}>
                <Glyphicon glyph="refresh"/> Neu Laden
            </Button>
            <Button bsStyle="primary"
                    onClick={() => this.props.markAsRead(this.props.unreadNotifications.map(
                        (notification) => notification.id
                    ))}
                    disabled={this.props.isFetchingNotifications || this.props.unreadNotifications.length === 0}>
                <Glyphicon glyph="check"/> Alle als gelesen markieren
            </Button>
            <Table hover style={{textAlign: "initial"}}>
                <thead>
                <tr>
                    <th style={{whiteSpace: 'normal', width: 100}}>Zeitpunkt</th>
                    <th style={{whiteSpace: 'normal'}}>Mitteilung</th>
                </tr>
                </thead>
                <tbody>
                {this.props.notifications.map(notification =>
                    <tr key={"notification_row_" + notification.id}>
                        <td style={{whiteSpace: 'normal', width: 100}}>
                            {toDate(new Date(notification.timestamp), {
                                replaceToday: true, replaceYesterday: true
                            })}
                            <br/>
                            {toTime(new Date(notification.timestamp))}
                        </td>
                        <td>
                            {!notification.read &&
                            <Badge style={{backgroundColor: "#337ab7"}}>Neu</Badge>
                            }
                            {" "}
                            {notification.message}
                        </td>
                    </tr>
                )}
                {this.props.notifications.length === 0 &&
                <tr>
                    <td style={{whiteSpace: 'normal', width: 100}}/>
                    <td>Keine Mitteilungen vorhanden</td>
                </tr>
                }
                </tbody>
            </Table>
            {this.props.isFetchingNotifications && <StackLoader label="Lade Mitteilungen..."/>}
        </Well>
    }

}

Notifications.propTypes = {
    isLoggedIn: PropTypes.bool.isRequired,
    isLoggingIn: PropTypes.bool.isRequired,
    fetchNotifications: PropTypes.func.isRequired,
    markAsRead: PropTypes.func.isRequired,
    isFetchingNotifications: PropTypes.bool.isRequired,
    notifications: PropTypes.array.isRequired,
    showLogin: PropTypes.func.isRequired,
};

export default Notifications