import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { getContact } from "../util/APIUtils";

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

    render() {
        let {id_contact, name, surname, information, email, phone, workplace, position, location, country, 
            city, price} = this.state;

        return (
            <div>
                <h3>Contact</h3>
                <div className="container">
                    <div>{id_contact}</div>
                    <div>{name}</div>
                    <div>{surname}</div>
                    <div>{information}</div>
                    <div>{email}</div>
                    <div>{phone}</div>
                    <div>{workplace}</div>
                    <div>{position}</div>
                    <div>{location}</div>
                    <div>{country}</div>
                    <div>{city}</div>
                    <div>{price}</div>
                </div>
            </div>
        )
    }
}

export default ContactComponent;


