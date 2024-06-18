abstract public class Conta {
    private int numeroDaConta;
    private double saldo;
    private Cliente cliente;

    //gets and sets
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getNumeroDaConta() {
        return this.numeroDaConta;
    }
    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //methods
    abstract public void deposita(int valor);
    abstract public void transfere(Conta conta, int valor);
    abstract public void consultaSaldo();


}