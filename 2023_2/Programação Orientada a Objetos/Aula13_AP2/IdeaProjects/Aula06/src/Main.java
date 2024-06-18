public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Salgadinho", 2.50, "Saboroso e salgado");
        Produto produto1 = new Produto("Chocolate", 3.00, "Derrete na boca");

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.addAoCarrinho(produto);
        carrinhoDeCompras.addAoCarrinho(produto1);

        double total = carrinhoDeCompras.getTotal();

        System.out.println("Valor total do carrinho de compras é de R$ "+total);
    }
}