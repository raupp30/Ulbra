public class Goleiro extends Jogador{
    @Override
    public void atacar(){
        System.out.println("O goleiro lançou a bola ao ataque");
    }
    @Override
    public void defender(){
        System.out.println("O goleiro fez uma defesa dificil");
    }
}
