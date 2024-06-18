public class Roupa extends Produto{
    @Override
    public void calcularPreco(){
        System.out.println("Calculando o preço da roupa");
    }
    @Override
    public void exibirDetalhes(){
        System.out.println("Exibindo detalhes da roupa");
    }
}
