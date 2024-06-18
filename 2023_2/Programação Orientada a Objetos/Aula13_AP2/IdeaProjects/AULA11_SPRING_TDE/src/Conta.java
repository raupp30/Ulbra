import java.util.ArrayList;
import java.util.List;

class Conta {
    private static int proximoNumeroConta = 1;
    private int numeroConta;
    private double saldo;

    public Conta(double saldo) {
        this.numeroConta = proximoNumeroConta++;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double novoSaldo) {
        saldo = novoSaldo;
    }
}