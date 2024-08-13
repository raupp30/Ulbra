public static void main(String[] args) {

  Livraria livraria = new Livraria();

  //add livro
    Livro livro1 = new Livro(1, "Diario de um banana", "Não sei", 1100, true);
    Livro livro2 = new Livro(2, "senhor dos aneis", "não sei dnvo", 1150, true);
    Livro livro3 = new Livro(2, "Livro 0000", "0000o", 1150, true);
    Livro livro4 = new Livro(2, "Livro 2222", "2222", 1150, true);
    Livro livro5 = new Livro(2, "Livro 2222", "2222", 1150, true);
    Livro livro6 = new Livro(2, "Livro 2222", "2222", 1150, true);

    livraria.inserirLivro(livro1);
    livraria.inserirLivro(livro2);

    //reservar livro
    livraria.reservar(1);

    //devolvendo
    livraria.devolver(1);

    //tentando devolver os q nao existe
    livraria.devolver(111);

    //listando disp
    livraria.listarDisponiveis();


}
