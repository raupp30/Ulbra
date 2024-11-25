import React from "react";

const Profile = ({ name, imageUrl }) => {
    return(
        <div className="profile">
            <img src={imageUrl} alt="img" className="logo" />
            <h2>{name}</h2>
        </div>
    )
}

export default Profile;