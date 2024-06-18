public class Main {
    public static void main(String[] args) {
        Produto produto;

        produto = new Roupa();
        produto.calcularPreco();
        produto.exibirDetalhes();
        System.out.println("--------");
        produto = new LIvro();
        produto.calcularPreco();
        produto.exibirDetalhes();
        System.out.println("--------");
        produto = new Eletronico();
        produto.calcularPreco();
        produto.exibirDetalhes();
    }
}