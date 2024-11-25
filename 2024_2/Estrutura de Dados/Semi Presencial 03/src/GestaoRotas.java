

import java.util.*;

public class GestaoRotas {
    private Map<String, List<String>> grafo;

    public GestaoRotas() {
        grafo = new HashMap<>();
    }

    public void adicionarConexao(String cidade1, String cidade2) {
        grafo.putIfAbsent(cidade1, new ArrayList<>());
        grafo.putIfAbsent(cidade2, new ArrayList<>());
        grafo.get(cidade1).add(cidade2);
        grafo.get(cidade2).add(cidade1);
    }

    public boolean existeCaminho(String inicio, String destino) {
        Set<String> visitados = new HashSet<>();
        Queue<String> fila = new LinkedList<>();
        fila.add(inicio);
        while (!fila.isEmpty()) {
            String atual = fila.poll();
            if (atual.equals(destino)) {
                return true;
            }
            if (!visitados.contains(atual)) {
                visitados.add(atual);
                fila.addAll(grafo.getOrDefault(atual, Collections.emptyList()));
            }
        }
        return false;
    }

    public void exibirGrafo() {
        System.out.println("Conexões entre cidades: " + grafo);
    }
}
