public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("VW", "GOL", 2021);
        Veiculo veiculo1 = new Veiculo("Toyota", "Etios", 2023);

        //ligar / desligar

        veiculo.ligar();
        veiculo.desligar();
        veiculo1.ligar();
        veiculo1.desligar();
    }
}