public class Gincana {
    private String nomeGincana;
    private int totalEstudantes;
    private Estudante estudanteVencedor;
    private int pontuacaoMaxima;

    public String getNomeGincana(){
        return nomeGincana;
    }
    public int getTotalEstudantes(){
        return totalEstudantes;
    }
    public Estudante getEstudanteVencedor(){
        return estudanteVencedor;
    }
    public int getPontuacaoMaxima(){
        return pontuacaoMaxima;
    }
    public String setNomeGincana(String nomeGincana){
        return nomeGincana;
    }
    public int setTotalEstudantes(int totalEstudantes){
        return totalEstudantes;
    }
    public Estudante setEstudanteVencedor(Estudante estudanteVencedor){
        return estudanteVencedor;
    }
    public int setPontuacaoMaxima(int pontuacaoMaxima){
        return pontuacaoMaxima;
    }
    public void adicionarEstudante(Estudante estudante){
        if(estudante.getPontos() > this.pontuacaoMaxima){
        this.estudanteVencedor = estudante;
        this.pontuacaoMaxima = estudante.getPontos();
        }
    }
    public void exibirVencedor(){
        System.out.println("O estudante vencedor é: " + this.estudanteVencedor.getNome() + " com sua incrível pontuação de " + this.estudanteVencedor.getPontos() + " pontos");
    }
}
