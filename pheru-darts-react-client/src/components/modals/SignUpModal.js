import React from 'react'
import {Button, FormControl, Glyphicon, Modal} from "react-bootstrap";
import PropTypes from 'prop-types';
import KeyUtil from "../../util/KeyUtil";

const initialState = {
    name: "",
    password: "",
    passwordRepeat: "",
    passwordsMatch: true
};

class SignUpModal extends React.Component {

    constructor(props) {
        super(props);
        this.state = initialState;
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handlePasswordRepeatChange = this.handlePasswordRepeatChange.bind(this);
    }

    componentDidUpdate(prevProps) {
        if (prevProps.show !== this.props.show
            && this.props.show === false) {
            this.setState(initialState);
        }
    }

    handleNameChange(value) {
        this.setState({name: value});
    }

    handlePasswordChange(value) {
        let match = value === this.state.passwordRepeat;
        this.setState({password: value, passwordsMatch: match});
    }

    handlePasswordRepeatChange(value) {
        let match = value === this.state.password;
        this.setState({passwordRepeat: value, passwordsMatch: match});
    }

    render() {
        return <Modal bsSize="small" backdrop='static' show={this.props.show} onHide={this.props.hide}>
            <Modal.Body style={{textAlign: 'center', paddingBottom: 0}}>
                <Modal.Title style={{marginBottom: 10}}>Registrieren</Modal.Title>
                <FormControl style={{marginBottom: 5}} type="text" value={this.state.name}
                             onChange={(e) => this.handleNameChange(e.target.value)}
                             onKeyDown={KeyUtil.ifEnterKey(() => {
                                 if (!this.isSignupDisabled()) {
                                     this.doSignUp()
                                 }
                             })}
                             placeholder="Benutzername" autoFocus/>
                <FormControl style={{marginBottom: 5}} type="password" value={this.state.password}
                             onChange={(e) => this.handlePasswordChange(e.target.value)}
                             onKeyDown={KeyUtil.ifEnterKey(() => {
                                 if (!this.isSignupDisabled()) {
                                     this.doSignUp()
                                 }
                             })}
                             placeholder="Passwort"/>
                <FormControl type="password" value={this.state.passwordRepeat}
                             onChange={(e) => this.handlePasswordRepeatChange(e.target.value)}
                             onKeyDown={KeyUtil.ifEnterKey(() => {
                                 if (!this.isSignupDisabled()) {
                                     this.doSignUp()
                                 }
                             })}
                             placeholder="Passwort wiederholen"/>
                {!this.state.passwordsMatch &&
                <div style={{color: "red"}}>
                    <Glyphicon glyph="remove"/> Passwort muss übereinstimmen
                </div>
                }
                <Button bsStyle="link" onClick={() => {
                    this.handlePasswordRepeatChange(undefined);
                    this.handlePasswordChange(undefined);
                    this.props.hide();
                    this.props.showLogin();
                }}>Zurück zur Anmeldung</Button>
            </Modal.Body>
            <Modal.Footer style={{textAlign: 'center'}}>
                <Button style={{width: 100}} bsStyle="primary"
                        disabled={this.isSignupDisabled()}
                        onClick={() => this.doSignUp()}>
                    Registrieren
                </Button>
                <Button style={{width: 100}} bsStyle='primary' onClick={this.props.hide}>Abbrechen</Button>
            </Modal.Footer>
        </Modal>;
    }

    isSignupDisabled() {
        return !this.state.passwordsMatch || this.props.isSigningUp || this.state.name === ""
            || this.state.password === "" || this.state.passwordRepeat === "";
    }

    doSignUp() {
        this.props.signUp(this.state.name, this.state.password);
    }
}

SignUpModal.propTypes = {
    show: PropTypes.bool,
    hide: PropTypes.func.isRequired,
    showLogin: PropTypes.func.isRequired,
    isSigningUp: PropTypes.bool,
    signUp: PropTypes.func.isRequired
};

export default SignUpModal;
