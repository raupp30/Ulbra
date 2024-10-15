import java.util.ArrayList;

public class Livraria {
    private ArrayList<Livro> livros;

    // Construtor
    public Livraria() {
        this.livros = new ArrayList<>();
    }

    // Método para inserir um novo livro na livraria
    public void inserirLivro(Livro livro) {
        if (livro != null) {
            livros.add(livro);
            System.out.println("Livro \"" + livro.getTitulo() + "\" adicionado à livraria.");
        }
    }

    // Método para listar todos os livros
    public void listarLivros() {
        System.out.println("Lista de todos os livros na livraria:");
        for (Livro livro : livros) {
            livro.exibirDetalhes();
            System.out.println();
        }
    }

    // Método para listar apenas os livros disponíveis
    public void listarDisponiveis() {
        System.out.println("Lista de livros disponíveis para empréstimo:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livro.exibirDetalhes();
                System.out.println();
            }
        }
    }
}
