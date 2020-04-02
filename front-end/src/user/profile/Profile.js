import React, { Component } from 'react';
import './Profile.css';

class Profile extends Component {
    constructor(props) {
        super(props);
        console.log(props);

        this.updateProfileClicked = this.updateProfileClicked.bind(this);
    }

    updateProfileClicked(id_user) {
        console.log("update " + id_user);
        this.props.history.push(`/profile/update/${id_user}`);
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
                            <p className="profile-email">{this.props.currentUser.email}</p>
                            <p className="profile-email">{this.props.currentUser.worlplace}</p>
                            <p className="profile-email">{this.props.currentUser.position}</p>
                            <p className="profile-email">{this.props.currentUser.location}</p>
                            <p className="profile-email">{this.props.currentUser.country}</p>
                            <p className="profile-email">{this.props.currentUser.city}</p>
                            <p className="profile-email">{this.props.currentUser.phone}</p>
                            <p className="profile-email">{this.props.currentUser.points}</p>
                            <p className="profile-email" type="password">{this.props.currentUser.password}</p>
                            <p className="profile-email">{this.props.currentUser.vk}</p>
                            <p className="profile-email">{this.props.currentUser.fb}</p>
                            <p className="profile-email">{this.props.currentUser.twitter}</p>
                            <p className="profile-email">{this.props.currentUser.website}</p>
                            <p className="profile-email">{this.props.currentUser.registered}</p>
                        </div>
                    </div>
                    <div>
                        <button onClick={() => this.updateProfileClicked(this.props.currentUser.id_user)}>Update Information</button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile