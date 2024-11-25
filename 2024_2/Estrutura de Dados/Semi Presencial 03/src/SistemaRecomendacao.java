

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SistemaRecomendacao {
    private Map<String, Set<String>> historicoVisualizacao;

    public SistemaRecomendacao() {
        historicoVisualizacao = new HashMap<>();
    }

    public void adicionarUsuario(String usuario) {
        historicoVisualizacao.putIfAbsent(usuario, new HashSet<>());
    }

    public void registrarVisualizacao(String usuario, String filme) {
        historicoVisualizacao.getOrDefault(usuario, new HashSet<>()).add(filme);
    }

    public Set<String> recomendar(String usuario) {
        return historicoVisualizacao.getOrDefault(usuario, new HashSet<>());
    }

    public void exibirHistorico(String usuario) {
        System.out.println("Histórico de " + usuario + ": " + historicoVisualizacao.getOrDefault(usuario, new HashSet<>()));
    }
}
