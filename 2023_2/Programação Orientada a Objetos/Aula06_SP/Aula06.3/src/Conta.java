abstract class Conta {
    private String numeroConta;
    private double saldo;

    public Conta(String numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado na conta " + numeroConta);
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado na conta " + numeroConta);
            return true;
        } else {
            System.out.println("Saldo insuficiente na conta " + numeroConta);
            return false;
        }
    }

    public void transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " da conta " + numeroConta + " para a conta " + destino.numeroConta);
        } else {
            System.out.println("Transferência não realizada devido a saldo insuficiente na conta " + numeroConta);
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}

