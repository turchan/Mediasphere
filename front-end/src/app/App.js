import React, { Component } from 'react';
import {
    Route,
    Switch
} from 'react-router-dom';
import AppHeader from '../common/AppHeader';
import Home from '../home/Home';
import Login from '../user/login/Login';
import Signup from '../user/signup/Signup';
import Profile from '../user/profile/Profile';
import UpdateProfile from '../user/profile/UpdateProfile';
import OAuth2RedirectHandler from '../user/oauth2/OAuth2RedirectHandler';
import NotFound from '../common/NotFound';
import LoadingIndicator from '../common/LoadingIndicator';
import Contacts from '../contacts/Contacts';
import UpdateContactComponent from "../contacts/UpdateContactComponent";
import ContactComponent from "../contacts/ContactComponent";
import AddContactComponent from "../contacts/AddContactComponent";
import Reports from "../reports/Reports";
import ReportComponent from "../reports/ReportComponent";
import AddReportComponent from "../reports/AddReportComponent";
import Materials from "../materials/Materials";
import MaterialComponent from "../materials/MaterialComponent";
import UpdateMaterialComponent from "../materials/UpdateMaterialComponent";
import AddMaterialComponent from "../materials/AddMaterialComponent";
import { getCurrentUser } from '../util/APIUtils';
import { ACCESS_TOKEN } from '../constants';
import PrivateRoute from '../common/PrivateRoute';
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';
import './App.css';



class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authenticated: false,
            currentUser: null,
            loading: false
        }

        this.loadCurrentlyLoggedInUser = this.loadCurrentlyLoggedInUser.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    loadCurrentlyLoggedInUser() {
        this.setState({
            loading: true
        });

        getCurrentUser()
            .then(response => {
                this.setState({
                    currentUser: response,
                    authenticated: true,
                    loading: false
                });
            }).catch(error => {
            this.setState({
                loading: false
            });
        });
    }

    handleLogout() {
        localStorage.removeItem(ACCESS_TOKEN);
        this.setState({
            authenticated: false,
            currentUser: null
        });
        Alert.success("You're safely logged out!");
    }

    componentDidMount() {
        this.loadCurrentlyLoggedInUser();
    }

    render() {
        if(this.state.loading) {
            return <LoadingIndicator />
        }

        return (
            <div className="app">
                <div className="app-top-box">
                    <AppHeader authenticated={this.state.authenticated} onLogout={this.handleLogout} />
                </div>
                <div className="app-body">
                    <Switch>
                        <Route exact path="/" component={Home}></Route>
                        <PrivateRoute exact path="/profile" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={Profile}></PrivateRoute>
                        <PrivateRoute exact path="/profile/update/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={UpdateProfile}></PrivateRoute>
                        <PrivateRoute exact path="/contacts" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={Contacts}></PrivateRoute>
                        <PrivateRoute exact path="/contacts/update/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={UpdateContactComponent}></PrivateRoute>
                        <PrivateRoute exact path="/contacts/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={ContactComponent}></PrivateRoute>
                        <PrivateRoute exact path="/createContact" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={AddContactComponent}></PrivateRoute>
                        <PrivateRoute exact path="/reports" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={Reports}></PrivateRoute>
                        <PrivateRoute exact path="/reports/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={ReportComponent}></PrivateRoute>
                        <PrivateRoute exact path="/createReport/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={AddReportComponent}></PrivateRoute>
                        <PrivateRoute exact path="/materials" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={Materials}></PrivateRoute>
                        <PrivateRoute exact path="/materials/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={MaterialComponent}></PrivateRoute>
                        <PrivateRoute exact path="/createMaterial" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={AddMaterialComponent}></PrivateRoute>
                        <PrivateRoute exact path="/materials/update/:id" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
                                      component={UpdateMaterialComponent}></PrivateRoute>                                      
                        <Route path="/login"
                               render={(props) => <Login authenticated={this.state.authenticated} {...props} />}></Route>
                        <Route path="/signup"
                               render={(props) => <Signup authenticated={this.state.authenticated} {...props} />}></Route>
                        <Route path="/oauth2/redirect" component={OAuth2RedirectHandler}></Route>
                        <Route component={NotFound}></Route>
                    </Switch>
                </div>
                <Alert stack={{limit: 3}}
                       timeout = {3000}
                       position='top-right' effect='slide' offset={65} />
            </div>
        );
    }
}

export default App;