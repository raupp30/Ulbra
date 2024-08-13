public class Pessoa{
    private String nome;
    private String email;

    public void Logar(){
        System.out.println("Usuário Logado");
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
