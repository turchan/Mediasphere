import React, { Component } from 'react';
import { getContact, deleteContact, purchaseContact } from "../util/APIUtils";

class ContactComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {  
            id_contact: this.props.match.params.id,
            name: '',
            surname: '',
            information: '',
            email: '',
            phone: '',
            workplace: '',
            position: '',
            location: '',
            country: '',
            city: '',
            price: null
        }

        this.updateContactClicked = this.updateContactClicked.bind(this);
        this.deleteContactClicked = this.deleteContactClicked.bind(this);
        this.purchaseClicked = this.purchaseClicked.bind(this);
    }

    componentDidMount() {
        getContact(this.state.id_contact)
            .then((response) => {
                console.log(response);
                this.setState({
                    name: response.name,
                    surname: response.surname,
                    information: response.information,
                    email: response.email,
                    phone: response.phone,
                    workplace: response.workplace,
                    position: response.position,
                    location: response.location,
                    country: response.country,
                    city: response.city,
                    price: response.price
                }, console.log(this.state));
            }).catch(error => {
                console.log(error)
                });
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

    purchaseClicked(id_contact) {
        this.setState({
            loading: true
        });
    
        console.log("purchase " + id_contact);
        purchaseContact(id_contact)
            .then(response => {
                this.setState({ message: `Purchase contact ${id_contact} Successful`})
                this.refreshContacts();
            })
        }

    render() {
        let {id_contact, name, surname, information, email, phone, workplace, position, location, country, 
            city, price} = this.state;

        return (
            <div className="container">
                <h3>Contact {name}</h3>
                <div>
                    <div>Name: {name}</div>
                    <div>Surname: {surname}</div>
                    <div>Information: {information}</div>
                    <div>Email: {email}</div>
                    <div>Phone: {phone}</div>
                    <div>Worklace: {workplace}</div>
                    <div>Position: {position}</div>
                    <div>Location: {location}</div>
                    <div>Country: {country}</div>
                    <div>City: {city}</div>
                    <div>Price: {price}</div>
                </div>
                <button className="btn btn-success" style={{ margin: '1rem' }} onClick={() => this.updateContactClicked(id_contact)}>Update</button>
                <button className="btn btn-danger" onClick={() => this.deleteContactClicked(id_contact)}>Delete</button>
                <button className="btn btn-success" style={{ margin: '1rem' }} onClick={() => this.purchaseClicked(id_contact)}>Purchase</button>
            </div>
        )
    }
}

export default ContactComponent;


