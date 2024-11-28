import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    Tabuleiro tabuleiro; // Corrigido para ser acessível na Main
    private ArrayList<Jogador> jogadores;
    private int rodadasMax;
    private int rodadaAtual;

    public Jogo(int rodadasMax) {
        this.tabuleiro = new Tabuleiro();
        this.jogadores = new ArrayList<>();
        this.rodadasMax = rodadasMax;
        this.rodadaAtual = 1;
    }

    // Método para adicionar jogadores
    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    // Método para retornar a lista de jogadores
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    // Método para movimentar jogadores
    public void movimentarJogador(Jogador jogador) {
        Random dado = new Random();
        int movimento = dado.nextInt(6) + 1; // número entre 1 e 6
        System.out.println(jogador.getNome() + " tirou " + movimento + " no dado!");

        Casa posicaoAtual = jogador.getPosicao();
        for (int i = 0; i < movimento; i++) {
            posicaoAtual = posicaoAtual.getProxima();
        }

        jogador.setPosicao(posicaoAtual);
        System.out.println(jogador.getNome() + " está agora na casa: " + posicaoAtual.getNome());

        // Interação com a casa
        interagirComCasa(jogador, posicaoAtual);

        if (jogador.getPresoPor() > 0) {
            jogador.setPresoPor(jogador.getPresoPor() - 1);
            System.out.println(jogador.getNome() + " está preso e não pode se mover nesta rodada.");
            return;
        }

    }

    // Método para interações com a casa
    private void interagirComCasa(Jogador jogador, Casa casa) {
        switch (casa.getTipo()) {
            case "Inicio":
                jogador.setSaldo(jogador.getSaldo() + jogador.getSalario());
                System.out.println(jogador.getNome() + " passou pelo início e recebeu seu salário!");
                break;
            case "Imovel":
                if (casa.getProprietario() == null) {
                    if (jogador.getSaldo() >= casa.getValorImovel()) {
                        jogador.setSaldo(jogador.getSaldo() - casa.getValorImovel());
                        casa.setProprietario(jogador);
                        jogador.addProprietario(casa);
                        System.out.println(jogador.getNome() + " comprou o imóvel " + casa.getNome());
                    } else {
                        System.out.println(jogador.getNome() + " não tem saldo suficiente para comprar o imóvel.");
                    }
                } else if (casa.getProprietario() != jogador) {
                    double aluguel = casa.getAluguel();
                    jogador.setSaldo(jogador.getSaldo() - aluguel);
                    casa.getProprietario().setSaldo(casa.getProprietario().getSaldo() + aluguel);
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
            case "Prisao":
                jogador.setPresoPor(2); // Número de rodadas preso
                System.out.println(jogador.getNome() + " foi para a prisão por 2 rodadas!");
                break;
            case "Sorte":
                double sorte = 500;
                jogador.setSaldo(jogador.getSaldo() + sorte);
                System.out.println(jogador.getNome() + " ganhou R$" + sorte + " de sorte!");
                break;
            case "Reves":
                double reves = 300;
                jogador.setSaldo(jogador.getSaldo() - reves);
                System.out.println(jogador.getNome() + " perdeu R$" + reves + " de revés!");
                break;

            // Implementar lógica para venda automática ou remoção do jogador.
        }
    }

    public void venderImovel(Jogador vendedor, Jogador comprador, Casa casa, double valor) {
        if (comprador.getSaldo() >= valor && casa.getProprietario() == vendedor) {
            vendedor.setSaldo(vendedor.getSaldo() + valor);
            comprador.setSaldo(comprador.getSaldo() - valor);
            casa.setProprietario(comprador);
            vendedor.removerProprietario(casa);
            comprador.addProprietario(casa);
            System.out.println(vendedor.getNome() + " vendeu o imóvel " + casa.getNome() + " para " + comprador.getNome() + " por R$" + valor);
        } else {
            System.out.println("Transação inválida.");
        }
    }


    // Método para iniciar o jogo
    public void iniciarJogo() {
        while (rodadaAtual <= rodadasMax) {
            System.out.println("Rodada " + rodadaAtual);
            for (Jogador jogador : jogadores) {
                movimentarJogador(jogador);
            }
            rodadaAtual++;
        }
    }
}
