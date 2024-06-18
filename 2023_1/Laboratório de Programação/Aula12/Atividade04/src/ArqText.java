public class ArqText extends Arquivo {
    @Override
    public void abrir() {
        System.out.println("Abrindo arquivo de texto");
    }
    @Override
    public void fechar() {
        System.out.println("Fechando arquivo de texto");
    }
}
