public class Equipe {

     String nome;
     int vitorias;
     int derrotas;
     int empates;
     int pontos;
     int kills;

     //Construtor
    Equipe(String nome, int vitorias, int derrotas, int empates, int pontos){
        this.nome = nome;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.pontos = 0;
        this.kills = 0;
    }
    //Getters e setters
    public String getNome(){
        return this.nome;
    }
    public int getVitorias(){
        return this.vitorias;
    }
    public int getDerrotas(){
        return this.derrotas;
    }
    public int getEmpates(){
        return this.empates;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setVitorias(int vitorias){
        this.vitorias = vitorias;
    }
    public void setDerrotas(int derrotas){
        this.derrotas = derrotas;
    }
    public void setEmpates(int empates){
        this.empates = empates;
    }
    //Incrementando atributo vitórias/derrotas/empates
    public void registrarVitoria(int kills){
        this.vitorias++;
        this.pontos += 3;
        this.kills = this.kills + kills;
    }
    public void registrarDerrota(int kills){
        this.derrotas++;
        this.kills = this.kills + kills;
    }
    public void registrarEmpate(int kills){
        this.empates++;
        this.pontos ++;
        this.kills = this.kills + kills;
    }

    public double calcAproveitamento(){
        int totalDeJogos = this.vitorias + this.derrotas + this.empates;
        int totalPontosPossiveis = totalDeJogos * 3;
        double aproveitamento = 0;
        if (totalPontosPossiveis > 0) {
            aproveitamento = (double) pontos / totalPontosPossiveis * 100;
        }return aproveitamento;
    }
    public void exibirInfo(){
        System.out.println("Nome da equipe: "+this.nome);
        System.out.println("Derrotas: "+this.derrotas);
        System.out.println("Vitórias: "+this.vitorias);
        System.out.println("Empates: "+this.empates);
        System.out.println("Pontos: "+this.pontos);
        System.out.println("Aproveitamento: "+this.calcAproveitamento());
        System.out.println("Kills "+this.kills);
    }

}
