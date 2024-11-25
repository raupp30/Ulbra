

import java.util.HashMap;
import java.util.Map;

public class ControlePontuacao {
    private Map<String, Integer> pontuacoes;

    public ControlePontuacao() {
        pontuacoes = new HashMap<>();
    }

    public void adicionarJogador(String jogador) {
        pontuacoes.put(jogador, 0);
    }

    public void atualizarPontuacao(String jogador, int pontos) {
        pontuacoes.put(jogador, pontuacoes.getOrDefault(jogador, 0) + pontos);
    }

    public String jogadorComMaiorPontuacao() {
        return pontuacoes.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado");
    }

    public void exibirPontuacoes() {
        System.out.println("Pontuações: " + pontuacoes);
    }
}
