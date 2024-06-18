//classe Biblioteca
class Biblioteca {
    private Livro[] livros = new Livro[100];
    private int [] aeiou = new int [23];

    public void adicionarLivro(Livro livro) {
        for (int i=0;i < livros.length; i++){
            if (livros[i] == null){
                livros[i] = livro;
            }
        }
    }
    public void removerLivro(Livro livro) {
        for (int i=0;i < livros.length; i++){
            if (livros[i] == livro){
                livros[i] = null;
            }
        }
    }

    public void atualizarDetalhesLivro(Livro livro, String titulo, String autor, int anoPublicacao) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == livro) {
                livros[i].setTitulo(titulo);
                livros[i].setAutor(autor);
                livros[i].setAnoPublicacao(anoPublicacao);
            }
        }
    }

    public boolean verificarDisponibilidadeLivro(Livro livro) {
            for (int i=0; i < livros.length; i++) {
                if (livros[i] == livro) {
                    return livros[i].isDisponibilidade();
                }
            }
        return false;
    }
}