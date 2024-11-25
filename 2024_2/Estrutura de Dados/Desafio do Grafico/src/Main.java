import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        // Adicionando cidades e estradas
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addCity("D");
        graph.addCity("E");

        graph.addRoad("A", "B", 10, 5);
        graph.addRoad("B", "C", 20, 15);
        graph.addRoad("C", "E", 25, 10);
        graph.addRoad("B", "D", 30, 20);
        graph.addRoad("A", "E", 50, 40);

        // Interatividade para bloqueios e consulta de rotas
        System.out.println("Bem-vindo à CargoFast!");
        System.out.println("Por favor, informe as estradas bloqueadas (separadas por vírgula, exemplo: B-C ou pressione Enter para continuar):");
        String blockedInput = scanner.nextLine();
        Set<String> blockedRoads = new HashSet<>();

        if (!blockedInput.isBlank()) {
            String[] blockedArray = blockedInput.split(",");
            Collections.addAll(blockedRoads, blockedArray);
        }

        System.out.print("Informe a cidade de partida: ");
        String start = scanner.nextLine();

        System.out.print("Informe a cidade de destino: ");
        String end = scanner.nextLine();

        System.out.print("Informe o custo máximo permitido: ");
        int maxCost = scanner.nextInt();

        // Buscar rota ótima
        List<String> route = graph.findOptimalRoute(start, end, maxCost, blockedRoads);

        System.out.println("Rota Ótima: " + String.join(" -> ", route));
    }
}