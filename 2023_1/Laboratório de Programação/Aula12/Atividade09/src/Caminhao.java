public class Caminhao extends Transporte{
    @Override
    public void carregar(){
        System.out.println("O caminhão está carregando");
    }
    @Override
    public void descarregar(){
        System.out.println("O caminhão chegou ao destino e está descarregando");
    }
}
