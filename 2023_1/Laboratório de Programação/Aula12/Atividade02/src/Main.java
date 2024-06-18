public class Main {
    public static void main(String[] args) {
        Pagamento pagamento;

        //cartão credito
        pagamento = new CartaoCredito();
        pagamento.RealizarPagamento();
        pagamento.EmitirRecibo();

        //cartão debito
        pagamento = new CartaoDebito();
        pagamento.RealizarPagamento();
        pagamento.EmitirRecibo();

        //dinheiro
        pagamento = new Dinheiro();
        pagamento.RealizarPagamento();
        pagamento.EmitirRecibo();
    }
}