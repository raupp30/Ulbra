public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int numPag;
    private boolean disp;

    public Livro(int id, String titulo, String autor, int numPag, boolean disp) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPag = numPag;
        this.disp = disp;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void exibirDetalhes(){
        System.out.println("ID: " +id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de páginas: " + numPag);
        System.out.println("Disponibilidade: " + (disp ? "Disponível" : "Indisponível"));
    }

    public void reservar(){
        if (disp){
            disp = false;
            System.out.println("O livro " +titulo + " foi reservado com sucesso");
        }else{
            System.out.println("O livro " +titulo + " já está reservado");
        }
    }
    public void devolver(){
        if (!disp){
            disp = true;
            System.out.println("O livro " +titulo + " voltou a estar disponível");
        }else{
            System.out.println("O livro " +titulo + " já está disponivel");
        }
    }
   public boolean isDisp(){
    return disp;
}
}
