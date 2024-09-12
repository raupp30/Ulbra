public class Aluno {
    String nome;
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    double getMedia(){
        return (nota1 + nota2) / 2;
    }

    boolean isAprovado(){
        return getMedia() >= 7.0;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Nota1: " + nota1 +", Nota2: " +nota2;
    }


}
