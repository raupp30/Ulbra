public class Main {
    public static void main(String[] args) {
        Animal animal;

        animal = new Cachorro();
        animal.comer();
        System.out.println("-----");
        animal.dormir();
        System.out.println("-----");
        animal.mover();
        System.out.println("-----");

        animal = new Gato();
        animal.comer();
        System.out.println("-----");
        animal.dormir();
        System.out.println("-----");
        animal.mover();
        System.out.println("-----");

        animal = new Peixe();
        animal.comer();
        System.out.println("-----");
        animal.dormir();
        System.out.println("-----");
        animal.mover();
    }
}