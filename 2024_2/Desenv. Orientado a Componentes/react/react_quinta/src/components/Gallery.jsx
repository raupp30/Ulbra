import React from "react";
import Profile from "./Profile";
import "./Gallery.css";

const Gallery = () => {
    return(
        <div className="gallery">
            <h1>Perfil</h1>
            <br />
            <div className="gallery-profiles">
                <Profile name="1" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
                <Profile name="2" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
                <Profile name="3" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
                <Profile name="4" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
                <Profile name="5" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
                <Profile name="6" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
                <Profile name="7" imageUrl = "https://i.imgur.com/MK3eW3As.jpg"/>
            </div>
        </div> 
    )
}
export default Gallery;
