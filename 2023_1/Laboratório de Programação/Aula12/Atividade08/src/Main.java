public class Main {
    public static void main(String[] args) {
        Impressora impressora;

        impressora = new ImpJatoTinta();
        impressora.imprimir();
        impressora.scan();
        System.out.println("-----------------");
        impressora = new ImpLaser();
        impressora.imprimir();
        impressora.scan();
        System.out.println("-----------------");
        impressora = new ImpMatricial();
        impressora.imprimir();
        impressora.scan();
        System.out.println("-----------------");
    }
}