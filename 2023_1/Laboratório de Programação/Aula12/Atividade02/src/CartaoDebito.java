class CartaoDebito extends Pagamento{
    @Override
    public void RealizarPagamento(){
        System.out.println("Realizando pagamento com cartão d debito");
    }
    @Override
    public void EmitirRecibo() {
        System.out.println("Emitindo recibo para pagamento cartão d debito");
    }
}
