import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import './ProdutoDetalhePage.css';

function ProdutoDetalhePage() {
    const parms = useParams();
    const [product, setProduct] = useState({});

    async function getProductById() {
        const response = await fetch(`http://localhost:3001/products/${parms.id}`);
        const product = await response.json();
        setProduct(product);
    }

    useEffect(() => {
        getProductById();
    }, []);

    return (
        <div className="product-detail-container">
            <div className="product-card">
                <img src={product.photo_url} alt={product.name} className="product-image" />
                <div className="product-info">
                    <h1>{product.name}</h1>
                    <p><strong>Preço:</strong> R$ {product.price}</p>
                    <p><strong>Descrição:</strong> {product.description}</p>
                </div>
            </div>
        </div>
    );
}

export default ProdutoDetalhePage;
