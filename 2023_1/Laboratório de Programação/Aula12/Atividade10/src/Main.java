public class Main {
    public static void main(String[] args) {
        DispArm dispArm;

        dispArm = new Celular();
        dispArm.gravarDados();
        dispArm.lerDados();
        System.out.println("-------------");
        dispArm = new Computador();
        dispArm.gravarDados();
        dispArm.lerDados();
        System.out.println("-------------");
    }
}