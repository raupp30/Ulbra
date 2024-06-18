import java.util.ArrayList;
import java.util.List;
class Banco {
    private List<Conta> contas = new ArrayList<>();

    public void criarConta(double saldoInicial) {
        Conta novaConta = new Conta(saldoInicial);
        contas.add(novaConta);
    }

    public List<Conta> listarContas() {
        return contas;
    }

    public Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void atualizarConta(int numeroConta, double novoSaldo) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.setSaldo(novoSaldo);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void removerConta(int numeroConta) {
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            contas.remove(conta);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}