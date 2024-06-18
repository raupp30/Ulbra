public class Main {
    public static void main(String[] args) {
        Produtos produto1 = new Produtos("Barra de chocolate", 7, 120);
        Produtos produto2 = new Produtos("Coca Cola 2L", 7.29, 639);
        Produtos produto3 = new Produtos("Água", 3, 2509);


        Loja loja = new Loja();
        //Listar produtos da loja
        loja.ListarProduto();

        //Add produtos
        loja.AdicionarProduto(produto1);
        loja.AdicionarProduto(produto2);
        loja.AdicionarProduto(produto3);

        //Listar produtos da loja novamente
        loja.ListarProduto();

        //Remover produto
        loja.RemoverProduto(produto3);

        //Listar produtos da loja novamente
        loja.ListarProduto();

        //Vender produto

        loja.VenderProduto(produto1, 2);
        loja.VenderProduto(produto2, 2);


        //Listar produtos da loja novamente
        loja.ListarProduto();

        //Adicionar estoque

        loja.adicionarEstoque(produto2, 2);
        loja.adicionarEstoque(produto1, 2);

        //Listar produtos da loja novamente
        loja.ListarProduto();
    }
}