// main
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Criando livros
        Livro livro1 = new Livro("Livro 0110", "Autor 0110", 1910, true);
        Livro livro2 = new Livro("Livro 0220", "Autor 0220", 1920, false);
        Livro livro3 = new Livro("Livro 0330", "Autor 0330", 1930, true);
        Livro livro4 = new Livro("Livro 0440", "Autor 0550", 1940, true);
        Livro livro5 = new Livro("Livro 0550", "Autor 0550", 1950, false);

        // adicionando os livros na biblioteca
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        // mostrando os detalhes dos livros
        System.out.println(livro1.detalhesDoProduto());
        System.out.println("------------------------");
        System.out.println(livro2.detalhesDoProduto());
        System.out.println("------------------------");
        System.out.println(livro3.detalhesDoProduto());
        System.out.println("------------------------");
        System.out.println(livro4.detalhesDoProduto());
        System.out.println("------------------------");
        System.out.println(livro5.detalhesDoProduto());
        System.out.println("------------------------");

        // verificando se o livro ta disponivel
        System.out.println("Disponibilidade do livro 1: " + biblioteca.verificarDisponibilidadeLivro(livro1));
        System.out.println("------------------------");
        System.out.println("Disponibilidade do livro 2: " + biblioteca.verificarDisponibilidadeLivro(livro2));
        System.out.println("------------------------");

        // Removendo um livro
        biblioteca.removerLivro(livro3);

        // Atualizando detalhes de um livro
        biblioteca.atualizarDetalhesLivro(livro2, "nvo titulo", "novo autor", 2023);

        System.out.println(livro2.detalhesDoProduto());
    }
}