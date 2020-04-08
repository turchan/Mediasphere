import React, { Component } from 'react';
import { getMaterials, getCurrentUser } from "../util/APIUtils";
import { Container, Row, Card, Button, CardDeck } from "react-bootstrap";

class Materials extends Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            materials: [],
            loading: false,
            currentUser: null,
            message: null
        }

        this.refreshMaterials = this.refreshMaterials.bind(this);
        this.showMaterialClicked = this.showMaterialClicked.bind(this);
        this.addMaterialClicked = this.addMaterialClicked.bind(this);

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

        this.refreshMaterials(); 
    }

    refreshMaterials() {
        this.setState({
            loading: true
        });
        
        getMaterials()
            .then(response => {
                console.log(response);
                this.setState({
                    materials: response, 
                    loading: false
                });
            }).catch(error => {
                console.log(error)
                this.setState({
                    loading: false
                });
            });
    }

    showMaterialClicked(id_material) {
        this.setState({
            loading: true
        });

        console.log("show " + id_material);
        this.props.history.push(`/materials/${id_material}`);
    }

    addMaterialClicked() {
        this.setState({
            loading: true
        });

        this.props.history.push(`/createMaterial`);
    }

    render() {
        console.log('render');
        return (
            <Container>
                <div>
                    <h1>All Materials</h1>
                    {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                </div>
                <Row>
                    <CardDeck>
                    {
                        this.state.materials.map(
                        material => 
                            <tr key={material.id_material}>
                                    <Card style={{ width: '18rem', margin: '1rem'}}>
                                        <Card.Body>
                                            <Card.Title>{material.title}</Card.Title>
                                            <Card.Subtitle className="mb-2 text-muted">{material.location} {material.deadline}</Card.Subtitle>
                                            <Card.Text>
                                                {material.description}
                                            </Card.Text>
                                            <Button onClick={() => this.showMaterialClicked(material.id_material)}>Show Material</Button>
                                        </Card.Body>
                                    </Card>
                            </tr>
                        )
                    }
                    </CardDeck>
                </Row>
                <div className="row">
                        <button className="btn btn-success" onClick={this.addMaterialClicked}>Create Material</button>
                </div>
            </Container>
        )
    }
}

export default Materials;

/*            <Container>
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
                                    <Card style={{ width: '18rem', margin: '1rem'}}>
                                        <Card.Body>
                                            <Card.Title>{contact.name} {contact.surname}</Card.Title>
                                            <Card.Subtitle className="mb-2 text-muted">{contact.position}</Card.Subtitle>
                                            <Card.Text>
                                                {contact.information}
                                            </Card.Text>
                                            <Button onClick={() => this.showContactClicked(contact.id_contact)}>Show Contact</Button>
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
            </Container>*/


            /*<div className="container">
                <h3>All Materials</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>description</th>
                                <th>Location</th>
                                <th>Deadline</th>
                                <th>Registered</th>
                                <th>Views</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                           {
                               this.state.materials.map(
                                   material => 
                                        <tr key={material.id_material}>
                                            <td onClick={() => this.showMaterialClicked(material.id_material)}>{material.title}>{material.title}</td>
                                            <td onClick={() => this.showMaterialClicked(material.id_material)}>{material.description}</td>
                                            <td onClick={() => this.showMaterialClicked(material.id_material)}>{material.location}</td>
                                            <td onClick={() => this.showMaterialClicked(material.id_material)}>{material.deadline}</td>
                                            <td onClick={() => this.showMaterialClicked(material.id_material)}>{material.registered}</td>
                                            <td onClick={() => this.showMaterialClicked(material.id_material)}>{material.views}</td>
                                            <td><button onClick={() => this.updateMaterialClicked(material.id_material)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deleteMaterialClicked(material.id_material)}>Delete</button></td>
                                        </tr>
                               )
                           }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addMaterialClicked}>Create Material</button>
                    </div>
                </div>
            </div> */