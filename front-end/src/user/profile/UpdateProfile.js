import React, { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { getCurrentUser, updateProfile } from "../../util/APIUtils";

class UpdateProfile extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_user: this.props.match.params.id,
            name: '',
            surname: '',
            email: '',
            workplace: '',
            position: '',
            location: '',
            country: '',
            city: '',
            phone: '',
            password: '',
            vk: '',
            fb: '',
            twitter: '',
            website: '',
            registered: '',
            provider: '',
            imageUrl: ''
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    componentDidMount() {

        getCurrentUser()
            .then((response) => {
                console.log(response);
                this.setState({
                    name: response.name,
                    surname: response.surname,
                    email: response.email,
                    workplace: response.workplace,
                    position: response.position,
                    location: response.location,
                    country: response.country,
                    city: response.city,
                    phone: response.phone,
                    password: response.password,
                    vk: response.vk,
                    fb: response.fb,
                    twitter: response.twitter,
                    website: response.website,
                    registered: response.registered,
                    provider: response.provider,
                    imageUrl: response.imageUrl
                }, console.log(this.state));
            }).catch(error => {
                console.log(error)
                });
    }

    onSubmit(values) {
        let profile = {
            id_user: this.state.id_user,
            name: values.name,
            surname: values.surname,
            email: values.email,
            workplace: values.workplace,
            position: values.position,
            location: values.location,
            country: values.country,
            city: values.city,
            phone: values.phone,
            password: values.password,
            vk: values.vk,
            fb: values.fb,
            twitter: values.twitter,
            website: values.website,
            registered: values.registered,
            provider: values.provider,
            imageUrl: values.imageUrl
        }

        updateProfile(profile)
            .then(() =>  this.props.history.push('/profile'));

        console.log(values);
    }

    render() {
        let {id_user, name, surname, email, workplace, position, location, country, 
            city, phone, password, vk, fb, twitter, website, registered, provider, image_url} = this.state;

        return (
            <div>
                <h3>Profile</h3>
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
                                        <Field className="form-control" type="text" name="id_user" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Name</label>
                                        <Field className="form-control" type="text" name="name" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>SurName</label>
                                        <Field className="form-control" type="text" name="surname" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Email</label>
                                        <Field className="form-control" type="text" name="email" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Workplace</label>
                                        <Field className="form-control" type="text" name="workplace" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Position</label>
                                        <Field className="form-control" type="text" name="position" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Location</label>
                                        <Field className="form-control" type="text" name="location" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Country</label>
                                        <Field className="form-control" type="text" name="country" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>City</label>
                                        <Field className="form-control" type="text" name="city" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Phone</label>
                                        <Field className="form-control" type="text" name="phone" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Password</label>
                                        <Field className="form-control" type="password" name="password" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>vk</label>
                                        <Field className="form-control" type="text" name="vk" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>fb</label>
                                        <Field className="form-control" type="text" name="fb" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>twitter</label>
                                        <Field className="form-control" type="text" name="twitter" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>website</label>
                                        <Field className="form-control" type="text" name="website" />
                                    </fieldset>
                                    <Field hidden name="registered" />
                                    <Field hidden name="provider" />
                                    <Field hidden name="image_url" />
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

export default UpdateProfile;