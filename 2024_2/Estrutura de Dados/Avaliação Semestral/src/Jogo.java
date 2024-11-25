import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private Tabuleiro tabuleiro;
    private ArrayList<Jogador> jogadores;
    private int rodadasMax;
    private int rodadaAtual;

    public Jogo(int rodadasMax) {
        this.tabuleiro = new Tabuleiro();
        this.jogadores = new ArrayList<>();
        this.rodadasMax = rodadasMax;
        this.rodadaAtual = 1;
    }

    //metodo p/ add jogadores

    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    //metodo p/ movimentar jogadores
    public void movimentarJogador(Jogador jogador) {
        Random dado = new Random();
        int movimento = dado.nextInt(6) + 1; // numero entre 1 e 6
        System.out.println(jogador.getNome() + " tirou " + movimento + " no dado!");

        Casa posicaoAtual = jogador.getPosicao();
        for (int i = 0; i < movimento; i++) {
            posicaoAtual = posicaoAtual.getProxima();
        }

        jogador.setPosicao(posicaoAtual);
        System.out.println(jogador.getNome() + " está agora na casa: " + posicaoAtual.getNome());

        //interação c/ a casa
        interagirComCasa(jogador, posicaoAtual);
    }

    //metodo para interações c/ a casa

    private void interagirComCasa(Jogador jogador, Casa casa) {
        switch (casa.getTipo()) {
            case "inicio":
                jogador.setSaldo(jogador.getSaldo() + jogador.getSalario());
                System.out.println(jogador.getNome() + " passou pelo inicio e recebeu seu salario!");
                break;
            case "Imovel":
                if (casa.getProprietario() == null) {
                    if (jogador.getSalario() >= casa.getValorImovel()) {
                        jogador.setSaldo(jogador.getSaldo() - casa.getValorImovel());
                        casa.setProprietario(jogador);
                        jogador.addProprietario(casa);
                        System.out.println(jogador.getNome() + " comprou o imovel " + casa.getNome());
                    } else {
                        System.out.println(jogador.getNome() + " não tem saldo suficiente para comprar o imovel.");
                    }
                }else if (casa.getProprietario() != jogador){
                        double aluguel = casa.getAluguel();
                        casa.getProprietario().setSaldo(casa.getProprietario().getSaldo() +aluguel);
                        System.out.println(jogador.getNome() + " pagou aluguel de R$" + aluguel + " para " + casa.getProprietario().getNome());
                    }
                break;
            case "Imposto":
                double imposto = jogador.getSaldo() * 0.05;
                jogador.setSaldo(jogador.getSaldo() - imposto);
                System.out.println(jogador.getNome() + " pagou R$" + imposto + " de imposto.");
                break;
            case "Restituição":
                double restituicao = jogador.getSalario() * 0.10;
                jogador.setSaldo(jogador.getSaldo() + restituicao);
                System.out.println(jogador.getNome() + " recebeu R$" + restituicao + " de restituição.");
                break;
                }
        }

        //metodo para iniciar o game
        public void Iniciar(){
        while (rodadaAtual <= rodadasMax){
            System.out.println("Rodada " + rodadaAtual);
            for (Jogador jogador : jogadores){
                movimentarJogador(jogador);
            }
            rodadaAtual++;
        }
    }
}