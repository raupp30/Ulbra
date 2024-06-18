public class LIvro extends Produto{
    @Override
    public void calcularPreco(){
        System.out.println("Calculando o preço do livro");
    }
    @Override
    public void exibirDetalhes(){
        System.out.println("Exibindo detalhes do livro");
    }
}
