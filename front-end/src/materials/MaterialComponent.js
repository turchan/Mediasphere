import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { getMaterial } from "../util/APIUtils";

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

    render() {
        let {id_material, title, description, deadline, registered, views} = this.state;

        return (
            <div>
                <h3>Material</h3>
                <div className="container">
                    <div>{id_material}</div>
                    <div>{title}</div>
                    <div>{description}</div>
                    <div>{deadline}</div>
                    <div>{registered}</div>
                    <div>{views}</div>
                </div>
            </div>
        )
    }
}

export default MaterialComponent;


