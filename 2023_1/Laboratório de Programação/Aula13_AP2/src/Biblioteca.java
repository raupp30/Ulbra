//classe Biblioteca
class Biblioteca {
    private Livro livro1;
    private Livro livro2;
    private Livro livro3;
    private Livro livro4;
    private Livro livro5;

    public Biblioteca() {
        livro1 = null;
        livro2 = null;
        livro3 = null;
        livro4 = null;
        livro5 = null;
    }

    public void adicionarLivro(Livro livro) {
        if (livro1 == null) {
            livro1 = livro;
        } else if (livro2 == null) {
            livro2 = livro;
        } else if (livro3 == null) {
            livro3 = livro;
        } else if (livro4 == null) {
            livro4 = livro;
        } else if (livro5 == null) {
            livro5 = livro;
        } else {
            System.out.println("A biblioteca está cheia.");
        }
    }

    public void removerLivro(Livro livro) {
        if (livro1 == livro) {
            livro1 = null;
        } else if (livro2 == livro) {
            livro2 = null;
        } else if (livro3 == livro) {
            livro3 = null;
        } else if (livro4 == livro) {
            livro4 = null;
        } else if (livro5 == livro) {
            livro5 = null;
        } else {
            System.out.println("O livro não foi encontrado na biblioteca.");
        }
    }

    public void atualizarDetalhesLivro(Livro livro, String titulo, String autor, int anoPublicacao) {
        if (livro1 == livro) {
            livro1.setTitulo(titulo);
            livro1.setAutor(autor);
            livro1.setAnoPublicacao(anoPublicacao);
        } else if (livro2 == livro) {
            livro2.setTitulo(titulo);
            livro2.setAutor(autor);
            livro2.setAnoPublicacao(anoPublicacao);
        } else if (livro3 == livro) {
            livro3.setTitulo(titulo);
            livro3.setAutor(autor);
            livro3.setAnoPublicacao(anoPublicacao);
        } else if (livro4 == livro) {
            livro4.setTitulo(titulo);
            livro4.setAutor(autor);
            livro4.setAnoPublicacao(anoPublicacao);
        } else if (livro5 == livro) {
            livro5.setTitulo(titulo);
            livro5.setAutor(autor);
            livro5.setAnoPublicacao(anoPublicacao);
        } else {
            System.out.println("O livro não foi encontrado na biblioteca.");
        }
    }

    public boolean verificarDisponibilidadeLivro(Livro livro) {
        if (livro1 == livro) {
            return livro1.isDisponibilidade();
        } else if (livro2 == livro) {
            return livro2.isDisponibilidade();
        } else if (livro3 == livro) {
            return livro3.isDisponibilidade();
        } else if (livro4 == livro) {
            return livro4.isDisponibilidade();
        } else if (livro5 == livro) {
            return livro5.isDisponibilidade();
        } else {
            System.out.println("O livro não foi encontrado na biblioteca.");
            return false;
        }
    }
}