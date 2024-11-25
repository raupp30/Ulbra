import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addCity(String city) {
        adjacencyList.putIfAbsent(city, new ArrayList<>());
    }

    public void addRoad(String from, String to, int distance, int cost) {
        adjacencyList.get(from).add(new Edge(from, to, distance, cost));
        adjacencyList.get(to).add(new Edge(to, from, distance, cost));
    }

    public void removeRoad(String from, String to) {
        adjacencyList.get(from).removeIf(edge -> edge.to.equals(to));
        adjacencyList.get(to).removeIf(edge -> edge.to.equals(from));
    }

    public List<String> findOptimalRoute(String start, String end, int maxCost, Set<String> blockedRoads) {
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        Map<String, Integer> costs = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> parents = new HashMap<>();

        for (String city : adjacencyList.keySet()) {
            costs.put(city, Integer.MAX_VALUE);
            distances.put(city, Integer.MAX_VALUE);
        }

        pq.add(new Route(start, 0, 0));
        distances.put(start, 0);
        costs.put(start, 0);
        parents.put(start, null);

        while (!pq.isEmpty()) {
            Route current = pq.poll();
            String currentCity = current.city;

            if (currentCity.equals(end)) {
                return reconstructPath(parents, end);
            }

            for (Edge edge : adjacencyList.getOrDefault(currentCity, new ArrayList<>())) {
                if (blockedRoads.contains(edge.from + "-" + edge.to) || blockedRoads.contains(edge.to + "-" + edge.from)) {
                    continue; // Ignorar estradas bloqueadas
                }

                int newCost = current.cost + edge.cost;
                int newDistance = current.distance + edge.distance;

                // Atualizar se encontramos uma rota melhor dentro do limite de custo
                if (newCost <= maxCost && newDistance < distances.get(edge.to)) {
                    distances.put(edge.to, newDistance);
                    costs.put(edge.to, newCost);
                    parents.put(edge.to, currentCity);
                    pq.add(new Route(edge.to, newDistance, newCost));
                }
            }
        }

        // Se não encontramos dentro do custo, buscar a rota mais curta
        return findShortestRoute(start, end, blockedRoads);
    }

    private List<String> findShortestRoute(String start, String end, Set<String> blockedRoads) {
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> parents = new HashMap<>();

        for (String city : adjacencyList.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }

        pq.add(new Route(start, 0, 0));
        distances.put(start, 0);
        parents.put(start, null);

        while (!pq.isEmpty()) {
            Route current = pq.poll();
            String currentCity = current.city;

            if (currentCity.equals(end)) {
                return reconstructPath(parents, end);
            }

            for (Edge edge : adjacencyList.getOrDefault(currentCity, new ArrayList<>())) {
                if (blockedRoads.contains(edge.from + "-" + edge.to) || blockedRoads.contains(edge.to + "-" + edge.from)) {
                    continue; // Ignorar estradas bloqueadas
                }

                int newDistance = current.distance + edge.distance;

                if (newDistance < distances.get(edge.to)) {
                    distances.put(edge.to, newDistance);
                    parents.put(edge.to, currentCity);
                    pq.add(new Route(edge.to, newDistance, current.cost));
                }
            }
        }

        return Collections.singletonList("No viable route available.");
    }

    private List<String> reconstructPath(Map<String, String> parents, String end) {
        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = parents.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    private static class Route {
        String city;
        int distance;
        int cost;

        Route(String city, int distance, int cost) {
            this.city = city;
            this.distance = distance;
            this.cost = cost;
        }
    }
}