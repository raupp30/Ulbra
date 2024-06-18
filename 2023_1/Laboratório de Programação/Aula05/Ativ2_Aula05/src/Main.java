public class Main {
    public static void main(String[] args) {
        carro carro1 = new carro("VW","2022", "Gol");

        System.out.println("marca: " + carro1.getMarca());
        System.out.println("ano: " + carro1.getAno());
        System.out.println("modelo: " + carro1.getModel());

    }
}