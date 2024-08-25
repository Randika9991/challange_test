import React, { Component } from "react";
import axios from "axios";

export class Home extends Component<any, any> {
    constructor(props: {}) {
        super(props);
        this.state = {
            user: null,
        };
    }

    componentDidMount() {
        this.fetchUserData();
    }

    fetchUserData = async () => {
        try {
            const response = await axios.get("https://88586822b4ba4bbe858cac2aa6e0cb9c.weavy.io/api/users");
            this.setState({ user: response.data });
        } catch (error) {
            console.error("Error fetching user data:", error);
        }
    };

    render() {
        const { user } = this.state;

        return (
            <div className="container mx-auto mt-5">
                <h1 className="text-2xl font-bold mb-5">User Details</h1>
                {user ? (
                    <div className="p-5 border rounded-lg shadow-md">
                        <img src={user.picture} alt={user.name} className="w-24 h-24 rounded-full mb-4" />
                        <h2 className="text-xl font-semibold">{user.name}</h2>
                        <p><strong>Email:</strong> {user.email}</p>
                        <p><strong>Phone Number:</strong> {user.phone_number}</p>
                        <p><strong>Nickname:</strong> {user.nickname}</p>
                        <p><strong>Comment:</strong> {user.comment}</p>
                        <p><strong>Directory:</strong> {user.directory}</p>
                        <p><strong>Tags:</strong> {user.tags.join(", ")}</p>
                        <p><strong>Metadata:</strong> Color - {user.metadata.color}, Size - {user.metadata.size}</p>
                        <p><strong>Suspended:</strong> {user.is_suspended ? "Yes" : "No"}</p>
                        <p><strong>Bot:</strong> {user.is_bot ? "Yes" : "No"}</p>
                    </div>
                ) : (
                    <p>Loading user data...</p>
                )}
            </div>
        );
    }
}
