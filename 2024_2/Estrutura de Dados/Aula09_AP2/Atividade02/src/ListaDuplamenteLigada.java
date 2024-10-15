public class ListaDuplamenteLigada {
    private No inicio;
    private No fim;

    public ListaDuplamenteLigada() {
        this.inicio = null;
        this.fim = null;
    }

    //add livro no inicio da lista
    public void addLivroNoInicio(int id, String titulo, String autor) {
        Livro novoLivro = new Livro(id, titulo, autor);
        No novoNo = new No(novoLivro);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    //add livro no fim da lista
    public void addLivroNoFim(int id, String titulo, String autor) {
        Livro novoLivro = new Livro(id, titulo, autor);
        No novoNo = new No(novoLivro);

        if (fim == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    //remove livro no inicio da lista
    public Livro removerLivroDoInicio(){
        if (inicio == null){
            System.out.println("Lista vazia");
            return null;
        }
        Livro livroRemovido = inicio.livro;
        if (inicio != null){
            inicio.anterior = null;
        } else {
            fim = null;
        }
        return livroRemovido;
    }

    //remover livro do fim da lista
    public Livro removerLivroDoFim(){
        if (fim == null){
            System.out.println("Lista vazia");
            return null;
        }
        Livro livroRemovido = fim.livro;
        if (fim != null){
            fim.proximo = null;
        } else {
            inicio = null;
        }
        return livroRemovido;
    }

    // buscar o livro pelo ID
    public Livro buscarLivroPorID(int id){
        No atual = inicio;
        while (atual != null){
            if (atual.livro.id == id){
                return atual.livro;
            }
            atual = atual.proximo;
        }
        return null;
    }

    // imprimir livros na ordem original
    public void imprimirLivrosOrdemOriginal() {
        No atual = inicio;
        if (atual == null){
            System.out.println("nenhum livro na lista");
            return;
        }
        while (atual != null){
            System.out.println(atual.livro);
            atual = atual.proximo;
        }
    }

    public void imprimirLivrosOrdemReversa() {
        No atual = fim;
        if (atual == null){
            System.out.println("nenhum livro na lista");
            return;
        }
        while (atual != null) {
            System.out.println(atual.livro);
            atual = atual.anterior;
        }
    }
}