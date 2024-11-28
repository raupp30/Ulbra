import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import './ProdutoEditar.css';

function ProdutoEditar() {
    const { id } = useParams();
    const [produto, setProduto] = useState({
        name: "",
        price: "",
        description: "",
        photo_url: ""
    });

    const navigation = useNavigate();

      // buscar o produto pelo ID
      useEffect(() => {
        async function fetchProduct() {
            const response = await fetch(`http://localhost:3001/products/${id}`);
            const data = await response.json();
            setProduto(data);
        }

        fetchProduct();
    }, [id]);

    // salvar as alterações do produto

    async function updateProduct(product) {
        await fetch(`http://localhost:3001/products/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(product)
        });

        navigation("/produtos");
    }


    // envio do form

    function handleSubmit(event) {
        event.preventDefault();

        const updatedProduct = {
            name: event.target.name.value, 
            price: event.target.price.value,
            description: event.target.description.value,
            photo_url: event.target.photo_url.value
        };

        updateProduct(updatedProduct);
    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="name">Nome</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={produto.name}
                        onChange={(e) => setProduto({ ...produto, name: e.target.value })}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="price">Preço</label>
                    <input
                        type="number"
                        id="price"
                        name="price"
                        value={produto.price}
                        onChange={(e) => setProduto({ ...produto, price: e.target.value })}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="description">Descrição</label>
                    <textarea
                        id="description"
                        name="description"
                        value={produto.description}
                        onChange={(e) => setProduto({ ...produto, description: e.target.value })}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="photo_url">Foto URL</label>
                    <input
                        type="text"
                        id="photo_url"
                        name="photo_url"
                        value={produto.photo_url}
                        onChange={(e) => setProduto({ ...produto, photo_url: e.target.value })}
                        required
                    />
                </div>

                <button type="submit">Atualizar Produto</button>
            </form>
        </>
    );
}

export default ProdutoEditar;