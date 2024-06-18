public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.criarConta(1000);
        banco.criarConta(2000);

        System.out.println("Contas no banco:");
        for (Conta conta : banco.listarContas()) {
            System.out.println("Conta " + conta.getNumeroConta() + ": Saldo " + conta.getSaldo());
        }

        banco.atualizarConta(1, 1500);
        banco.removerConta(2);
    }
}
