public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    // add um novo pedido ao fim da fila (enqueue)
    public void enqueue(T dado) {
        No<T> novoNo = new No<>(dado); // cria um novo nó com o dado
        if (fim != null) { // se a fila não estiver vazia
            fim.proximo = novoNo; // o próximo do último nó aponta para o novo nó
        }
        fim = novoNo; // o novo nó se torna o último
        if (inicio == null) { // SE a fila estava vazia
            inicio = fim; // o inicio tbm aponta para o novo nó
        }
    }

    // remove o pedido mais antigo da fila (dequeue)
    public T dequeue() {
        if (inicio == null) { // verifica se a fila está vazia
            System.out.println("Fila vazia.");
            return null; // retorna null se estiver vazia
        }
        T dado = inicio.dado; // armazena o dado do nó que será removido
        inicio = inicio.proximo; // move o início para o próximo nó
        if (inicio == null) { // SE a fila ficou vazia
            fim = null; // o fim também deve ser nulo
        }
        return dado; // retorna o dado removido
    }

    // imprime todos os pedidos pendentes
    public void printQueue() {
        No<T> atual = inicio; // começa a impressão a partir do início
        if (atual == null) { // VERIFICA se a fila está vazia
            System.out.println("Fila de pedidos pendentes está vazia.");
            return;
        }
        while (atual != null) { // percorre a fila até o final
            System.out.println(atual.dado); // imprime o dado do nó atual
            atual = atual.proximo; // move para o próximo nó
        }
    }
}
