public class Navio extends Transporte{
    @Override
    public void carregar(){
        System.out.println("O Navio está carregando");
    }
    @Override
    public void descarregar(){
        System.out.println("O Navio chegou ao destino e está descarregando");
    }
}
