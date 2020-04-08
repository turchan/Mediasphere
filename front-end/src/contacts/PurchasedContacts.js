import React, { Component } from "react";
import { getCurrentUser } from "../util/APIUtils";

class PurchasedContacts extends Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            loading: false,
            currentUser: []
        }
        this.showContactClicked = this.showContactClicked.bind(this);
    }       

    componentDidMount() {

        getCurrentUser()
            .then(response => {
                this.setState({
                    currentUser: response.purchaseList,
                    authenticated: true,
                    loading: false
                });
            }).catch(error => {
            this.setState({
                loading: false
            });
        });
    }

    showContactClicked(id_contact) {
        this.setState({
            loading: true
        });

        console.log("show " + id_contact);
        this.props.history.push(`/contacts/${id_contact}`);
    }

    render() {
        console.log('render ');
        console.log(this.state)
        let {name} = this.state;

        return (
            <div className="container">
                <h3>Purchased Contacts</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Information</th>
                            </tr>
                        </thead>
                        <tbody>
                           {
                               this.state.currentUser.map(
                                   contact => 
                                        <tr key={contact.id_contact.id_contact}>
                                            <td>{contact.id_contact.name}</td>
                                            <td>{contact.id_contact.surname}</td>
                                            <td>{contact.id_contact.information}</td>                            
                                        </tr>
                               )
                           }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default PurchasedContacts;

/*<div className="container">
                <h3>Purchased Contacts</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Information</th>
                            </tr>
                        </thead>
                        <tbody>
                           {
                               this.state.purchases.map(
                                   contact => 
                                        <tr key={contact.id_contact}>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.name}</td>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.surname}</td>                            
                                        </tr>
                               )
                           }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addContactClicked}>Create Contact</button>
                    </div>
                </div>
            </div>*/