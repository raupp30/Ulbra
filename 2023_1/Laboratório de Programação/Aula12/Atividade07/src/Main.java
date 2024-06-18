public class Main {
    public static void main(String[] args) {
        Jogador jogador;

        jogador = new Atacante();
        jogador.atacar();
        jogador.defender();
        System.out.println("---------------");
        jogador = new MeioCampo();
        jogador.atacar();
        jogador.defender();
        System.out.println("---------------");
        jogador = new Goleiro();
        jogador.atacar();
        jogador.defender();
        System.out.println("---------------");
    }
}