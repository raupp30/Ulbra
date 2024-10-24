import React from "react";
import './Header.css';

const Header = () => {
    return (
        <header className="header">
            <div className="header-content">
                <img className="logo" src="https://media-gru1-1.cdn.whatsapp.net/v/t61.24694-24/328748430_872851657669446_3378865265141113007_n.jpg?ccb=11-4&oh=01_Q5AaIE4uLJPlRKraRE8eGNzOKTx0QZ2ZtwyoTQn4zEcbufRl&oe=6722AAC3&_nc_sid=5e03e0&_nc_cat=101" alt="Logo" />
            </div>
            <h1 className="title" >Entrevero</h1>
        </header>
    );
}

export default Header;