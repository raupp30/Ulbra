import java.util.ArrayList;

public class Jogador {
    private String nome;
    private double saldo;
    private double salario;
    private Casa posicao; //ref p/ a posição atual do tabuleiro
    private ArrayList<Casa> propriedades;

    public Jogador(String nome, double saldo, double salario) {
        this.nome = nome;
        this.saldo = saldo;
        this.salario = salario;
        this.propriedades = new ArrayList<>();
    }

    public void addProprietario(Casa casa){
        propriedades.add(casa);
    }

    public void removerProprietario(Casa casa){
        propriedades.remove(casa);
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Casa> getPropriedades() {
        return propriedades;
    }

    public Casa getPosicao() {
        return posicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPosicao(Casa posicao) {
        this.posicao = posicao;
    }
}
