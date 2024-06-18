public class Main {
    public static void main(String[] args) {
        // Criando instâncias de contas
        ContaCorrente cc1 = new ContaCorrente("12345");
        ContaPoupanca cp1 = new ContaPoupanca("67890");
        ContaSalario cs1 = new ContaSalario("54321");

        // Realizando operações nas contas
        cc1.depositar(1000.0);
        cp1.depositar(500.0);
        cs1.depositar(200.0);

        cc1.transferir(cp1, 300.0);
        cp1.sacar(50.0);

        // Consultando saldos
        System.out.println("Saldo Conta Corrente: R$" + cc1.consultarSaldo());
        System.out.println("Saldo Conta Poupança: R$" + cp1.consultarSaldo());
        System.out.println("Saldo Conta Salário: R$" + cs1.consultarSaldo());
    }
}