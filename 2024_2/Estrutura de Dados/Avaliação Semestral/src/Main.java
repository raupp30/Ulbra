public class Main {
    public static void main(String[] args) {
        // Criação do jogo
        Jogo jogo = new Jogo(10);

        // Criação de jogadores
        Jogador jogador1 = new Jogador("Maria", 1500, 200);
        Jogador jogador2 = new Jogador("João", 1500, 200);

        jogo.addJogador(jogador1);
        jogo.addJogador(jogador2);

        // Criação do tabuleiro com casas fictícias
        Casa inicio = new Casa("Inicio", "Início", 0, 0);
        Casa casa1 = new Casa("Imovel", "Casa do Bosque", 200000, 1100);
        Casa casa2 = new Casa("Imovel", "Apartamento Central", 350000, 1800);
        Casa casa3 = new Casa("Imovel", "Vila das Flores", 400000, 2200);
        Casa casa4 = new Casa("Imovel", "Pousada da Praia", 500000, 2700);
        Casa casa5 = new Casa("Imovel", "Mansão da Colina", 600000, 3300);
        Casa casa6 = new Casa("Imovel", "Residência do Lago", 450000, 2500);
        Casa casa7 = new Casa("Imovel", "Cobertura Diamante", 700000, 3700);
        Casa casa8 = new Casa("Imovel", "Edifício Horizonte", 550000, 2900);
        Casa casa9 = new Casa("Imovel", "Chácara do Sol", 300000, 1600);
        Casa casa10 = new Casa("Imovel", "Fazenda Boa Vista", 250000, 1300);

        // Adicionando as casas ao tabuleiro
        jogo.tabuleiro.addCasa(inicio);
        jogo.tabuleiro.addCasa(casa1);
        jogo.tabuleiro.addCasa(casa2);
        jogo.tabuleiro.addCasa(casa3);
        jogo.tabuleiro.addCasa(casa4);
        jogo.tabuleiro.addCasa(casa5);
        jogo.tabuleiro.addCasa(casa6);
        jogo.tabuleiro.addCasa(casa7);
        jogo.tabuleiro.addCasa(casa8);
        jogo.tabuleiro.addCasa(casa9);
        jogo.tabuleiro.addCasa(casa10);

        // Configurando a posição inicial dos jogadores
        for (Jogador jogador : jogo.getJogadores()) {
            jogador.setPosicao(inicio);
        }

        // Iniciar o jogo
        jogo.iniciarJogo();
    }
}
