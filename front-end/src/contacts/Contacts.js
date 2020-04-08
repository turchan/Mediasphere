import React, { Component } from 'react';
import { getContacts, getCurrentUser } from "../util/APIUtils";
import { Container, Row, Card, Button, CardDeck } from "react-bootstrap";


class Contacts extends Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            contacts: [],
            loading: false,
            currentUser: null,
            message: null
        }

        this.refreshContacts = this.refreshContacts.bind(this);
        this.showContactClicked = this.showContactClicked.bind(this);
        this.addContactClicked = this.addContactClicked.bind(this);
        this.addReportClicked = this.addReportClicked.bind(this);

    }       

    componentDidMount() {

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

    addContactClicked() {
        this.props.history.push(`/createContact`);
    }

    addReportClicked(id_contact) {
        this.props.history.push(`/createReport/${id_contact}`);
    }

    render() {
        console.log('render');
        return (
            <Container>
                <div>
                    <h1>All Contacts</h1>
                    {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                </div>
                <Row>
                    <CardDeck>
                    {
                        this.state.contacts.map(
                        contact => 
                            <tr key={contact.id_contact}>
                                    <Card style={{ width: '19rem', margin: '1rem'}} className="shadow-sm p-3 mb-5 bg-white rounded">
                                        <Card.Body>
                                            <Card.Title>{contact.name} {contact.surname}</Card.Title>
                                            <Card.Subtitle className="mb-2 text-muted">{contact.position}</Card.Subtitle>
                                            <Card.Text>
                                                {contact.information}
                                            </Card.Text>
                                            <div>
                                                <Button onClick={() => this.showContactClicked(contact.id_contact)}>Show Contact</Button>
                                                <Button className="btn btn-danger" style={{margin: '1rem'}} onClick={() => this.addReportClicked(contact.id_contact)}>Report</Button>
                                            </div>
                                        </Card.Body>
                                    </Card>
                            </tr>
                        )
                    }
                    </CardDeck>
                </Row>
                <div className="row">
                    <button className="btn btn-primary " onClick={this.addContactClicked}>Create Contact</button>
                </div>
            </Container>
        )
    }
}

export default Contacts;

/*<div className="container">
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
                                <th>Delete</th>
                                <th>Report</th>
                                <th>Purchase</th>
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
                                            <td><button className="btn btn-success" onClick={() => this.updateContactClicked(contact.id_contact)}>Update</button></td>
                                            <td><button className="btn btn-danger" onClick={() => this.deleteContactClicked(contact.id_contact)}>Delete</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.addReportClicked(contact.id_contact)}>Report</button></td>
                                            <td><button className="btn btn-success" onClick={() => this.purchaseClicked(contact.id_contact)}>Purchase</button></td>
                                        </tr>
                               )
                           }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-primary " onClick={this.addContactClicked}>Create Contact</button>
                    </div>
                </div>
            </div> */