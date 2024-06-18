public class ContaCorrente extends Conta{

    //constructor
    public ContaCorrente(Cliente cliente) {
        this.setCliente(cliente);
        super.setSaldo(0);
    }

    //methods
    @Override
    public void deposita(int valor) {
        super.setSaldo(super.getSaldo()+valor);
    }
    @Override
    public void transfere(Conta conta, int valor) {
        if (valor <= super.getSaldo()) {
            conta.deposita(valor);
            super.setSaldo(super.getSaldo()-valor);
        }
        else {
            System.out.println("Saldo insuficiente.");
        }
    }
    @Override
    public void consultaSaldo() {
        System.out.println("O saldo da conta é: "+super.getSaldo());
    }

}