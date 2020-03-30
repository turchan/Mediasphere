import React, { Component } from 'react';
import { getContacts, deleteContact } from "../util/APIUtils";
import { NavLink, Router } from 'react-router-dom';


class Contacts extends Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            contacts: [],
            loading: false,
            message: null
        }

        this.refreshContacts = this.refreshContacts.bind(this);
        this.showContactClicked = this.showContactClicked.bind(this);
        this.updateContactClicked = this.updateContactClicked.bind(this);
        this.deleteContactClicked = this.deleteContactClicked.bind(this);
        this.addContactClicked = this.addContactClicked.bind(this);
    }       

    componentDidMount() {
        this.refreshContacts(); 
    }

    refreshContacts() {
        this.setState({
            loading: true
        });
        
        getContacts()
            .then(response => {
                console.log(response);
                this.setState({
                    contacts: response, 
                    loading: false
                });
            }).catch(error => {
                console.log(error)
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

    updateContactClicked(id_contact) {
        this.setState({
            loading: true
        });

        console.log("update " + id_contact);
        this.props.history.push(`/contacts/update/${id_contact}`);
    }

    deleteContactClicked(id_contact) {
        this.setState({
            loading: true
        });

        console.log("delete " + id_contact);
        deleteContact(id_contact)
            .then(response => {
                this.setState({ message: `Delete of contact ${id_contact} Successful` })
                this.refreshContacts();
            })
    }

    addContactClicked() {
        this.setState({
            loading: true
        });

        this.props.history.push(`/contacts/add`);
    }

    render() {
        console.log('render');
        return (
            <div className="container">
                <h3>All Contacts</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Information</th>
                                <th>Price</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                           {
                               this.state.contacts.map(
                                   contact => 
                                        <tr key={contact.id_contact}>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.name}</td>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.surname}</td>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.information}</td>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.price}</td>
                                            <td><button onClick={() => this.updateContactClicked(contact.id_contact)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deleteContactClicked(contact.id_contact)}>Delete</button></td>
                                        </tr>
                               )
                           }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addContactClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default Contacts;