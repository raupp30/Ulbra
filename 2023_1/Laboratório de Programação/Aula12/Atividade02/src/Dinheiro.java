class Dinheiro extends Pagamento {
    @Override
    public void RealizarPagamento(){
        System.out.println("Realizando pagamento com dinheiro");
    }
    @Override
    public void EmitirRecibo() {
        System.out.println("Emitindo recibo para pagamento cartão d dinheiro");
    }
}
