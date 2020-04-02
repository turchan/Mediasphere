import React, { Component } from "react";
import { getReports, getCurrentUser, deleteReport, getReport} from "../util/APIUtils";

class Reports extends Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            reports: [],
            currentUser: null,
            loading: false,
            message: null
        }

        this.refreshReports = this.refreshReports.bind(this);
        this.deleteReportClicked = this.deleteReportClicked.bind(this);
        this.showReportClicked = this.showReportClicked.bind(this);
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

        this.refreshReports();
    }

    refreshReports() {
        this.setState({
            loading: true
        });

        getReports()
            .then(response => {
                console.log(response);
                this.setState({
                    reports: response, 
                    loading: false
                });
            }).catch(error => {
                console.log(error)
                this.setState({
                    loading: false
                });
            });
    }

    showReportClicked(id_report) {
        this.setState = {
            loading: true
        }

        console.log("show " + id_report);
        this.props.history.push(`/reports/${id_report}`);
    }

    deleteReportClicked(id_report) {
        this.setState({
            loading: true
        });

        console.log("delete " + id_report);
        deleteReport(id_report)
            .then(response => {
                this.setState({ message: `Delete of contact ${id_report} Successful` })
                this.refreshContacts();
            })
    }

   render() {
        console.log('render');
        return (
            <div className="container">
                <h3>All Reports</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Sent</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                           {
                               this.state.reports.map(
                                   report => 
                                        <tr key={report.id_report}>
                                            <td onClick={() => this.showReportClicked(report.id_report)}>{report.title}</td>
                                            <td onClick={() => this.showReportClicked(report.id_report)}>{report.content}</td>
                                            <td onClick={() => this.showReportClicked(report.id_report)}>{report.sent}</td>
                                            <td><button onClick={() => this.deleteReportClicked(report.id_report)}>Delete</button></td>
                                        </tr>
                               )
                           }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default Reports;

/*<td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.title}</td>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.content}</td>
                                            <td onClick={() => this.showContactClicked(contact.id_contact)}>{contact.Sent}</td>*/
//                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}