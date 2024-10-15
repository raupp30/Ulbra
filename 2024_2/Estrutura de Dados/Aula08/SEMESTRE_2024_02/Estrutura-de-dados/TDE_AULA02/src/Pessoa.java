public class Pessoa {
    private String nome;
    private String email;

    // Construtor
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    // Método logar
    public void logar() {
        System.out.println("Usuário logado");
    }
}
