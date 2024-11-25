public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo(10); //10 rodadas
        
        //criando jogadores
        
        Jogador jogador1 = new Jogador("João", 1000, 200);
        Jogador jogador2 = new Jogador("Andres", 1000, 200);

        jogo.addJogador(jogador1);
        jogo.addJogador(jogador2);

        //criando o tabuleiro

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.addCasa(new Casa("Inicio", "Inicio", 0, 0));
        tabuleiro.addCasa(new Casa("Imovel", "Casa preta", 300, 50));
        tabuleiro.addCasa(new Casa("Imposto", "Imposto", 0, 0));
        tabuleiro.addCasa(new Casa("Restituição", "Restituição", 0, 0));

        jogador1.setPosicao(tabuleiro.getInicio());
        jogador2.setPosicao(tabuleiro.getInicio());

        jogo.Iniciar();

        }
    }
