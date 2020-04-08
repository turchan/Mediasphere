import React, { Component } from 'react';
import { getMaterial, deleteMaterial } from "../util/APIUtils";
import { Button } from "react-bootstrap";

class MaterialComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_material: this.props.match.params.id,
            title: '',
            description: '',
            location: '',
            deadline: '',
            registered: '',
            views: ''
        }

        this.updateMaterialClicked = this.updateMaterialClicked.bind(this);
        this.deleteMaterialClicked = this.deleteMaterialClicked.bind(this);
    }

    componentDidMount() {
        getMaterial(this.state.id_material)
            .then((response) => {
                console.log(response);
                this.setState({
                    title: response.title,
                    description: response.description,
                    deadline: response.deadline,
                    registered: response.registered,
                    views: response.views
                }, console.log(this.state));
            }).catch(error => {
                console.log(error)
                });
    }

    updateMaterialClicked(id_material) {
        this.setState({
            loading: true
        });

        console.log("update " + id_material);
        this.props.history.push(`/materials/update/${id_material}`);
    }

    deleteMaterialClicked(id_material) {
        this.setState({
            loading: true
        });

        console.log("delete " + id_material);
        deleteMaterial(id_material)
            .then(response => {
                this.setState({ message: `Delete of material ${id_material} Successful` })
                this.refreshMaterials();
            })
    }

    render() {
        let {id_material, title, description, deadline, registered, views} = this.state;

        return (
            <div className="container">
                <h3>Material {title}</h3>
                <div>
                    <div>Title: {title}</div>
                    <div>Description: {description}</div>
                    <div>Deadline: {deadline}</div>
                    <div>Registered: {registered}</div>
                    <div>Views: {views}</div>
                </div>

                <Button style={{margin: '1rem'}} onClick={() => this.updateMaterialClicked(id_material)}>Update</Button>
                <Button className="btn btn-danger" onClick={() => this.deleteMaterialClicked(id_material)}>Delete</Button>
            </div>
        )
    }
}

export default MaterialComponent;


