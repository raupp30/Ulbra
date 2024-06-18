public class Main {
    public static void main(String[] args) {
        Transporte transporte;

        transporte = new Caminhao();
        transporte.carregar();
        transporte.descarregar();
        System.out.println("-----------");
        transporte = new Navio();
        transporte.carregar();
        transporte.descarregar();
        System.out.println("-----------");
        transporte = new Trem();
        transporte.carregar();
        transporte.descarregar();
        System.out.println("-----------");
    }
}