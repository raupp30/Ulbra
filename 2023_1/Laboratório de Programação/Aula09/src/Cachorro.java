public class Cachorro {
    public String nome;
    public String raca;
    public int idade;

    public Cachorro(String nome, String raca, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
    }
    public Cachorro(String nome, String raca){
        this.nome = nome;
        this.raca = raca;
        this.idade = 1;
    }

    public String getNome(){
        return this.nome;
    }
    public String getRaca(){
        return this.raca;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setRaca(String raca){
        this.raca = raca;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
}



