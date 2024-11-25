
import java.util.Arrays;

public class JogoTabuleiro {
    private String[][] tabuleiro;

    public JogoTabuleiro(int linhas, int colunas) {
        tabuleiro = new String[linhas][colunas];
        for (String[] linha : tabuleiro) {
            Arrays.fill(linha, ".");
        }
    }

    public void fazerMovimento(int linha, int coluna, String jogador) {
        if (tabuleiro[linha][coluna].equals(".")) {
            tabuleiro[linha][coluna] = jogador;
        } else {
            System.out.println("Movimento inválido!");
        }
    }

    public void exibirTabuleiro() {
        for (String[] linha : tabuleiro) {
            System.out.println(Arrays.toString(linha));
        }
    }
}
