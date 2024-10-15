// Arquivo: ListaEncadeada.java

public class ListaEncadeada<T> {
    private Node<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Adiciona um elemento no início da lista
    public void adicionarNoInicio(T valor) {
        Node<T> novoNo = new Node<>(valor);
        novoNo.setProximo(inicio);
        inicio = novoNo;
        tamanho++;
    }

    // Adiciona um elemento no final da lista
    public void adicionarNoFim(T valor) {
        Node<T> novoNo = new Node<>(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            Node<T> atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    // Adiciona um elemento em uma posição específica
    public void adicionarNaPosicao(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            adicionarNoInicio(valor);
        } else {
            Node<T> novoNo = new Node<>(valor);
            Node<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
            tamanho++;
        }
    }

    // Remove o primeiro elemento da lista e retorna seu valor
    public T removerDoInicio() {
        if (inicio == null) {
            throw new RuntimeException("Lista vazia");
        }
        Node<T> removido = inicio;
        inicio = inicio.getProximo();
        tamanho--;
        return removido.getValor();
    }

    // Remove o último elemento da lista e retorna seu valor
    public T removerDoFim() {
        if (inicio == null) {
            throw new RuntimeException("Lista vazia");
        }
        if (inicio.getProximo() == null) {
            return removerDoInicio();
        }
        Node<T> atual = inicio;
        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }
        Node<T> removido = atual.getProximo();
        atual.setProximo(null);
        tamanho--;
        return removido.getValor();
    }

    // Remove o elemento de uma posição específica e retorna seu valor
    public T removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            return removerDoInicio();
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }
        Node<T> removido = atual.getProximo();
        atual.setProximo(removido.getProximo());
        tamanho--;
        return removido.getValor();
    }

    // Remove um elemento pelo valor e retorna seu valor
    public T removerPorValor(T elemento) {
        if (inicio == null) {
            throw new RuntimeException("Lista vazia");
        }
        if (inicio.getValor().equals(elemento)) {
            return removerDoInicio();
        }
        Node<T> atual = inicio;
        while (atual.getProximo() != null && !atual.getProximo().getValor().equals(elemento)) {
            atual = atual.getProximo();
        }
        if (atual.getProximo() == null) {
            throw new RuntimeException("Elemento não encontrado");
        }
        Node<T> removido = atual.getProximo();
        atual.setProximo(removido.getProximo());
        tamanho--;
        return removido.getValor();
    }

    // Retorna o valor do elemento em uma determinada posição
    public T buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getValor();
    }

    // Retorna a posição de um elemento com o valor especificado
    public int buscarPosicao(T valor) {
        Node<T> atual = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (atual.getValor().equals(valor)) {
                return i;
            }
            atual = atual.getProximo();
        }
        return -1;  // Retorna -1 se não for encontrado
    }

    // Atualiza o valor de um nó em uma posição específica
    public void atualizar(int posicao, T novoValor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setValor(novoValor);
    }


    public int tamanho() {
        return tamanho;
    }


    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Remove todos os elementos da lista
    public void limpar() {
        inicio = null;
        tamanho = 0;
    }

    // Retorna uma representação textual da lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> atual = inicio;
        while (atual != null) {
            sb.append(atual.getValor()).append(" -> ");
            atual = atual.getProximo();
        }
        sb.append("null");
        return sb.toString();
    }
}
