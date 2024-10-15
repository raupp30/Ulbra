public class Professor extends Pessoa {

    // Construtor
    public Professor(String nome, String email) {
        super(nome, email);
    }

    // Sobrescrita do método logar
    @Override
    public void logar() {
        System.out.println("Professor logado");
    }
}
