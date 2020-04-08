import React, { Component } from "react";
import { getReport } from "../util/APIUtils";

class ReportComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            id_report: this.props.match.params.id,
            title: '',
            content: '',
            sent: ''
        }
    }

    componentDidMount() {
        getReport(this.state.id_report)
            .then((response) => {
                console.log(response);
                this.setState({
                    title: response.title,
                    content: response.content,
                    sent: response.sent,
                    }, console.log(this.state));
            }).catch(error => {
                console.log(error)
                });
    }

    render() {
        let {id_report, title, content, sent} = this.state;

        return (
            <div className="container">
                <h3>Report</h3>
                <div>
                    <div>Title: {title}</div>
                    <div>Contant: {content}</div>
                    <div>Sent: {sent}</div>
                </div>
            </div>
        )
    }
}

export default ReportComponent;