public class No {
    Livro livro;
    No anterior;
    No proximo;

    public No (Livro livro) {
        this.livro = livro;
        this.anterior = null;
        this.proximo = null;
    }
}
