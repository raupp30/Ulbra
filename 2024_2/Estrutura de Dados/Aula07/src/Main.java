public class Main {
    public static void main(String[] args) {

        Pilha livros = new Pilha(5);

        livros.empilhar("Livro 1");
        livros.empilhar("Livro 2");
        livros.empilhar("Livro 3");

        String livroRemovido = livros.desempilhar();
        System.out.println(livroRemovido + " foi removido da pilha.");
        System.out.println(livros);

        livros.empilhar("Livro 4");
        livros.empilhar("Livro 5");
        livros.empilhar("Livro 6");
        System.out.println(livros);
    }

}