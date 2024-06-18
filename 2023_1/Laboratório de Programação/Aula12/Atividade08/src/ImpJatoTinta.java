public class ImpJatoTinta extends Impressora{
    @Override
    public void imprimir(){
        System.out.println("A impressora jato tinta está imprimindo");
    }
    @Override
    public void scan(){
        System.out.println("A impressora jato tinta está scanneando");
    }
}
