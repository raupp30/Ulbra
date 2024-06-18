public class Main {
    public static void main(String[] args) {
        pessoa titular = new pessoa("João", 25, 1.75);
        ContaBancaria conta = new ContaBancaria("123456", 1000.0, titular);

        System.out.println("Saldo inicial: " + conta.getSaldo());

        conta.depositar(500.0);
        System.out.println("Saldo após depósito: " + conta.getSaldo());

        conta.sacar(200.0);
        System.out.println("Saldo após saque: " + conta.getSaldo());

        conta.sacar(1500.0); // saldo insuficiente
    }
}