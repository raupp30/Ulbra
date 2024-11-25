
public class Casa {
    private String tipo;
    private String nome;
    private double valorImovel;
    private double aluguel;
    private Jogador proprietario;
    private Casa proxima; // ref para a prox casa

    public Casa(String tipo, String nome, double valorImovel, double aluguel){
        this.tipo = tipo;
        this.nome = nome;
        this.valorImovel = valorImovel;
        this.aluguel = valorImovel;
        this.proprietario = null;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public double getAluguel() {
        return aluguel;
    }

    public Jogador getProprietario() {
        return proprietario;
    }

    public Casa getProxima() {
        return proxima;
    }

    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }

    public void setProxima(Casa proxima) {
        this.proxima = proxima;
    }
}
