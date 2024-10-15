public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(Pedido pedido) {
        No<T> novoNo = new No<>((T) pedido); // Cast para T
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public Pedido pop() {
        if (topo == null) {
            System.out.println("Pilha vazia");
            return null;
        }
        Pedido pedido = (Pedido) topo.dado;
        topo = topo.proximo;
        return pedido;
    }

    public void printStack() {
        No<T> atual = topo;
        if (atual == null) {
            System.out.println("Pilha de pedidos cancelados está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
