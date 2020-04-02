import React, { Component } from 'react';
import { getMaterials, getCurrentUser, deleteMaterial } from "../util/APIUtils";

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
        this.updateMaterialClicked = this.updateMaterialClicked.bind(this);
        this.deleteMaterialClicked = this.deleteMaterialClicked.bind(this);
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

    addMaterialClicked() {
        this.setState({
            loading: true
        });

        this.props.history.push(`/createMaterial`);
    }

    render() {
        console.log('render');
        return (
            <div className="container">
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
            </div>
        )
    }
}

export default Materials;