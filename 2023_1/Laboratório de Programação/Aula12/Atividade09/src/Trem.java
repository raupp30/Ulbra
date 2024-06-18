public class Trem extends Transporte{
    @Override
    public void carregar(){
        System.out.println("O trem está carregando");
    }
    @Override
    public void descarregar(){
        System.out.println("O trem chegou ao destino e está descarregando");
    }
}
