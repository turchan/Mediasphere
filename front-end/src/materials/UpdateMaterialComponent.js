import React, { Component } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { getMaterial, updateMaterial } from "../util/APIUtils";

class UpdateMaterialComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_material: this.props.match.params.id,
            title: '',
            description: '',
            location: '',
            deadline: '',
            registered: '',
            views: null,
            id_user: null
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    componentDidMount() {
        getMaterial(this.state.id_material)
            .then((response) => {
                console.log(response);
                this.setState({
                    title: response.title,
                    description: response.description,
                    location: response.location,
                    deadline: response.deadline,
                    registered: response.registered,
                    views: response.views,
                    id_user: response.id_user
                }, console.log(this.state));
            }).catch(error => {
                console.log(error)
                });
    }

    onSubmit(values) {
        let material = {
            id_material: this.state.id_material,
            title: values.title,
            description: values.description,
            location: values.location,
            deadline: values.deadline,
            registered: values.registered,
            views: values.views,
            id_user: values.id_user
        }

        updateMaterial(material)
            .then(() =>  this.props.history.push('/materials'));

        console.log(values);
    }

    render() {
        let {id_material, title, description, deadline, registered, views, id_user} = this.state;

        return (
            <div>
                <h3>Material</h3>
                <div className="container">
                    <Formik
                        enableReinitialize={true} 
                        initialValues={this.state}
                        onSubmit={this.onSubmit}
                    >
                        {
                            (props) => (
                                <Form>
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id_material" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Title</label>
                                        <Field className="form-control" type="text" name="title" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Location</label>
                                        <Field className="form-control" type="text" name="location" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>DeadLine</label>
                                        <Field className="form-control" type="text" name="deadline" />
                                    </fieldset>
                                    <Field hidden name="registered"/>
                                    <Field hidden name="views"/>
                                    <Field hidden name="id_user"/>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </div>
        )
    }
}

export default UpdateMaterialComponent;


