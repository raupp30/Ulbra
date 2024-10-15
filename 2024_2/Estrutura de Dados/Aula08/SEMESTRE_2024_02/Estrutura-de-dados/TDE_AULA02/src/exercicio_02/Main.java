public class Main {
    public static void main(String[] args) {
        // Criando a livraria
        Livraria livraria = new Livraria();

        // Criando alguns livros
        Livro livro1 = new Livro("1984", "George Orwell", 328);
        Livro livro2 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1178);
        Livro livro3 = new Livro("O Alquimista", "Paulo Coelho", 208);

        // Inserindo livros na livraria
        livraria.inserirLivro(livro1);
        livraria.inserirLivro(livro2);
        livraria.inserirLivro(livro3);

        // Listando todos os livros
        livraria.listarLivros();

        // Reservando um livro
        livro1.reservar();

        // Tentando reservar novamente o mesmo livro
        livro1.reservar();

        // Listando apenas os livros disponíveis
        livraria.listarDisponiveis();

        // Devolvendo o livro
        livro1.devolver();

        // Listando novamente os livros disponíveis
        livraria.listarDisponiveis();
    }
}
