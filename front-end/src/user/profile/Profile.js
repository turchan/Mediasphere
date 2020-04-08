import React, { Component } from 'react';
import './Profile.css';
import { Container, Row, Card, Button, CardDeck } from "react-bootstrap";

class Profile extends Component {
    constructor(props) {
        super(props);
        console.log(props);

        this.updateProfileClicked = this.updateProfileClicked.bind(this);
        this.showContactClicked = this.showContactClicked.bind(this);
        this.addReportClicked = this.addReportClicked.bind(this);
    }

    updateProfileClicked(id_user) {
        console.log("update " + id_user);
        this.props.history.push(`/profile/update/${id_user}`);
    }

    showContactClicked(id_contact) {
        this.setState({
            loading: true
        });

        console.log("show " + id_contact);
        this.props.history.push(`/contacts/${id_contact}`);
    }

    addReportClicked(id_contact) {
        this.props.history.push(`/createReport/${id_contact}`);
    }

    render() {
        return (
            <div className="profile-container">
                <div className="container">
                    <div className="profile-info">
                        <div className="profile-avatar">
                            {
                                this.props.currentUser.imageUrl ? (
                                    <img src={this.props.currentUser.imageUrl} alt={this.props.currentUser.name}/>
                                ) : (
                                    <div className="text-avatar">
                                        <span>{this.props.currentUser.name && this.props.currentUser.name[0]}</span>
                                    </div>
                                )
                            }
                        </div>
                        <div className="profile-name">
                            <h2>{this.props.currentUser.name}</h2>
                            <p className="profile-email">Email: {this.props.currentUser.email}</p>
                            <p className="profile-email">Workplace: {this.props.currentUser.worlplace}</p>
                            <p className="profile-email">Position: {this.props.currentUser.position}</p>
                            <p className="profile-email">Location: {this.props.currentUser.location}</p>
                            <p className="profile-email">Country: {this.props.currentUser.country}</p>
                            <p className="profile-email">City: {this.props.currentUser.city}</p>
                            <p className="profile-email">Phone: {this.props.currentUser.phone}</p>
                            <p className="profile-email">Points: {this.props.currentUser.points}</p>
                            <p className="profile-email">Vk: {this.props.currentUser.vk}</p>
                            <p className="profile-email">fb: {this.props.currentUser.fb}</p>
                            <p className="profile-email">twitter: {this.props.currentUser.twitter}</p>
                            <p className="profile-email">website: {this.props.currentUser.website}</p>
                        </div>
                    </div>
                    <div>
                        <button className="btn btn-primary" style={{ margin: '1rem'}} onClick={() => this.updateProfileClicked(this.props.currentUser.id_user)}>Update Information</button>
                    </div>
                </div>
                <div className="container shadow p-3 mb-5 bg-white rounded">
                    <h3>Purchased Contacts</h3>
                    <div>
                    {
                        this.props.currentUser.purchaseList.map(
                            contact => 
                                    <tr key={contact.id_contact.id_contact}>
                                        <Card style={{ width: '19rem', margin: '1rem'}} className="shadow-sm p-3 mb-5 bg-white rounded">
                                        <Card.Body>
                                            <Card.Title>{contact.id_contact.name} {contact.id_contact.surname}</Card.Title>
                                            <Card.Subtitle className="mb-2 text-muted">{contact.id_contact.position}</Card.Subtitle>
                                            <Card.Text>
                                                {contact.id_contact.information}
                                            </Card.Text>
                                            <div>
                                                <Button onClick={() => this.showContactClicked(contact.id_contact.id_contact)}>Show Contact</Button>
                                                <Button className="btn btn-danger" style={{margin: '1rem'}} onClick={() => this.addReportClicked(contact.id_contact.id_contact)}>Report</Button>
                                            </div>
                                        </Card.Body>
                                    </Card>                       
                                    </tr>
                        )
                    }
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile

/*<table className="table">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Information</th>
                                </tr>
                            </thead>
                            <tbody>
                            {
                                this.props.currentUser.purchaseList.map(
                                    contact => 
                                            <tr key={contact.id_contact.id_contact}>
                                                <td>{contact.id_contact.name}</td>
                                                <td>{contact.id_contact.surname}</td>
                                                <td>{contact.id_contact.information}</td>                            
                                            </tr>
                                )
                            }
                            </tbody>
                        </table> */