class CartaoCredito extends Pagamento {
    @Override
    public void RealizarPagamento(){
        System.out.println("Realizando pagamento com cartão d credito");
    }
    @Override
    public void EmitirRecibo() {
        System.out.println("Emitindo recibo para pagamento cartão d crédito");
    }
}
