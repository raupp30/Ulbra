import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./ProdutoPage.css";

function ProdutoPage() {
    const urlApi = "http://localhost:3001/products";
    const [produtos, setProdutos] = useState([]);
    const navigation = useNavigate();

    async function getAllProducts() {
        const response = await fetch(urlApi);
        const produtos = await response.json();
        setProdutos(produtos);
    }

    async function deleteProduct(id) {
        await fetch(`${urlApi}/${id}`, {
            method: "DELETE",
        });

        getAllProducts();
    }

    useEffect(() => {
        getAllProducts();
    }, []);

    return (
        <div className="products-container">
            {produtos.map((cadaProduto) => (
                <div className="product-card" key={cadaProduto.id}>
                    <img
                        src={cadaProduto.photo_url}
                        alt={cadaProduto.name}
                        className="product-image"
                    />
                    <div className="product-info">
                        <h3>{cadaProduto.name}</h3>
                        <p>R$ {cadaProduto.price}</p>
                    </div>
                    <div className="product-actions">
                        <button
                            className="delete-btn"
                            onClick={() => deleteProduct(cadaProduto.id)}
                        >
                            Deletar
                        </button>
                        <button
                            className="view-btn"
                            onClick={() => navigation(`/produtos/${cadaProduto.id}`)}>
                            Visualizar
                        </button>
                        <button
                            className="edit-btn"
                            onClick={() => navigation(`/produtos/editar/${cadaProduto.id}`)}>
                            Editar
                        </button>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default ProdutoPage;
