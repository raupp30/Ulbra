public class Aluno extends Pessoa {

    // Construtor
    public Aluno(String nome, String email) {
        super(nome, email);
    }

    // Sobrescrita do método logar
    @Override
    public void logar() {
        System.out.println("Aluno logado");
    }
}
