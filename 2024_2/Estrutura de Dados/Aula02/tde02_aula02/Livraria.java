import java.util.ArrayList;
import java.util.List;

public class Livraria {
    private List<Livro> livros;

    public Livraria(List<Livro> livros) {
        this.livros = livros;
    }

    public Livraria() {
        livros = new ArrayList<>();
    }

    public void inserirLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            livro.exibirDetalhes();
            System.out.println();
        }
    }

    public void listarDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisp()) {
                livro.exibirDetalhes();
                System.out.println();
            }
        }
    }

    public void reservar(int id) {
        boolean encontrado = false;

        for (Livro livro : livros) {
            if (livro.getId() == id) {
                encontrado = true;
                if (livro.isDisp()) {
                    livro.reservar();
                } else {
                    System.out.println("O livro ID" + id + " já está reservado");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("O livro ID " + id + " não foi encontrado");
        }
    }

    public void devolver(int id) {
        boolean encontrado = false;

        for (Livro livro : livros) {
            if (livro.getId() == id) {
                encontrado = true;
                livro.devolver();
                break;
            }
        }

        if (!encontrado) {
            System.out.println("O livro ID " + id + " não foi encontrado");
        }
    }
}
