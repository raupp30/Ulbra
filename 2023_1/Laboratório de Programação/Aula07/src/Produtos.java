public class Produtos {
    String nome;
    double preco;
    int quantidade;

    public Produtos(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
        System.out.println("Nome redefinido");
    }

    public void setPreco(double preco) {
        this.preco = preco;
        System.out.println("Preço redefinido");
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        System.out.println("Quantidade redefinida");
    }
}
