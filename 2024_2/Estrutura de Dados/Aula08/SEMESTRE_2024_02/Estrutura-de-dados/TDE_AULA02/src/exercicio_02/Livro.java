public class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean disponibilidade;

    // Construtor
    public Livro(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.disponibilidade = true; // O livro é disponível por padrão
    }

    // Método para exibir detalhes do livro
    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de Páginas: " + numeroPaginas);
        System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
    }

    // Método para reservar o livro
    public void reservar() {
        if (disponibilidade) {
            disponibilidade = false;
            System.out.println("Livro \"" + titulo + "\" reservado com sucesso.");
        } else {
            System.out.println("Livro \"" + titulo + "\" já está reservado.");
        }
    }

    // Método para devolver o livro
    public void devolver() {
        if (!disponibilidade) {
            disponibilidade = true;
            System.out.println("Livro \"" + titulo + "\" devolvido com sucesso.");
        } else {
            System.out.println("Livro \"" + titulo + "\" já está disponível.");
        }
    }

    // Getter para disponibilidade
    public boolean isDisponivel() {
        return disponibilidade;
    }
}
