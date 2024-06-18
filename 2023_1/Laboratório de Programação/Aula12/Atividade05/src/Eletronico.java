public class Eletronico extends Produto{
    @Override
    public void calcularPreco(){
        System.out.println("Calculando o preço do produto eletronico");
    }
    @Override
    public void exibirDetalhes(){
        System.out.println("Exibindo detalhes do produto eletronico");
    }
}
