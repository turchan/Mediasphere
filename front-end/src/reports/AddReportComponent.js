import React, { Component } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { createReport } from "../util/APIUtils";

class AddReportComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_report: null,
            title: '',
            content: '',
            id_contact: this.props.match.params.id
        }

        this.onSubmit = this.onSubmit.bind(this);
    }

    onSubmit(values) {
        let report = {
            id_report: this.state.id_report,
            title: values.title,
            content: values.content
        }

        createReport(report, this.state.id_contact)
            .then(() =>  this.props.history.push('/contacts'));

        console.log(values);
    }

    render() {
        return (
            <div>
                <h3>New Report</h3>
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
                                        <Field className="form-control" type="text" name="id_report" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Title</label>
                                        <Field className="form-control" type="text" name="title" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Content</label>
                                        <Field className="form-control" type="text" name="content" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <Field className="form-control" type="text" name="id_contact" hidden />
                                    </fieldset>
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

export default AddReportComponent;