public class exercicio3 {
    public static void main(String[] args) {
        int anterior = 1;

        for (int proximo = 0, cont = 0; cont <15; cont++){
            System.out.println(proximo);
            proximo = proximo + anterior;
            anterior = proximo - anterior;
        }
    }
}
