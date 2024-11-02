import React from "react";
import { Link } from "react-router-dom";
import './Header.css';

const Header = () => {
    return (
        <header className="header">
            <img src="https://crehana-blog.imgix.net/media/filer_public/c2/71/c27103aa-ebb5-4258-b68c-d2b89f20fd6c/logo-nasa-gusano.jpg?auto=format&q=50" alt="Logo" className="logo" /> {/* Adicione o caminho da imagem */}
            <nav className="nav-links">
                <Link to={"/"}>Home</Link>
                <Link to={"/contato"}>Contato</Link>
                <Link to={"/sobre"}>Sobre</Link>
            </nav>
        </header>
    );
}

export default Header;
