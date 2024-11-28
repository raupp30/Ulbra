import { useNavigate } from "react-router-dom";
import './ProdutoCadastrar.css';

function ProdutoCadastrar() {
    const navigation = useNavigate()

    async function saveProduct(product) {
        await fetch("http://localhost:3001/products", {
            method: "POST",
            body: JSON.stringify(product)
        })

        navigation("/produtos")
    }

    function handleSubmit(event) {
        event.preventDefault()
        const formData = new FormData(event.target)

        const produto = {
            name: formData.get("name"), 
            price: formData.get("price"),
            description: formData.get("description"),
            photo_url: formData.get("photo_url"),
        }

        saveProduct(produto)
        console.log (produto)
    }


    return <> 
        <form onSubmit={handleSubmit}>
            <input name="name" required placeholder="Nome:"/>
            <input name="price" required placeholder="Preço:" />
            <input name="description" required placeholder="Descrição:" />
            <input name="photo_url" required placeholder="Foto:" />
        <button type="submit">Cadastrar</button>
        </form>
    </>
}

export default ProdutoCadastrar;