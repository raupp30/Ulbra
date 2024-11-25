public class TesteBiblio {
    public static void main(String[] args) {
        ListaDuplamenteLigada biblioteca = new ListaDuplamenteLigada();

        // add livros
        biblioteca.addLivroNoFim(1, "Diario de um banana", "João Raupp");
        biblioteca.addLivroNoFim(2, "Goosebumps", "João Pedro");
        biblioteca.addLivroNoFim(3, "O alquimista", "Andres");

        System.out.println("----------------------------------");

        // imprimindo livros na ordem original
        System.out.println("Livros na ordem original:");
        biblioteca.imprimirLivrosOrdemOriginal();

        System.out.println("----------------------------------");

        // removendo livro do inicio
        Livro livroRemovido = biblioteca.removerLivroDoInicio();
        System.out.println("Livro removido do inicio: " + livroRemovido);

        System.out.println("----------------------------------");

        // imprimindo livros na ordem original após remover
        System.out.println("Livros na ordem original após remover:");
        biblioteca.imprimirLivrosOrdemOriginal();

        System.out.println("----------------------------------");

        // removendo livro do fim
        livroRemovido = biblioteca.removerLivroDoFim();
        System.out.println("Livro removido do fim: " + livroRemovido);

        System.out.println("----------------------------------");

        //imprimindo livros na ordem reversa
        System.out.println("Livro na ordem reversa: ");
        biblioteca.imprimirLivrosOrdemReversa();

        System.out.println("----------------------------------");

        //buscando um livro por ID
        Livro livroBuscado = biblioteca.buscarLivroPorID(1);
        System.out.println("Livro buscado por ID 2: " + (livroBuscado != null ? livroBuscado : "NOT FOUND"));
    }
}