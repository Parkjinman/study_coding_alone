package inflearn.algorithm.Graph;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>() {{
            put("A", Arrays.asList("B", "D", "E"));
            put("B", Arrays.asList("A", "C", "D"));
            put("C", Arrays.asList("B"));
            put("D", Arrays.asList("A", "B"));
            put("E", Arrays.asList("A"));
        }};

        bfs(graph, "A");
    }

    private static void bfs(Map<String, List<String>> graph, String startVertex) {
        ArrayList<String> visited = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();

        visited.add(startVertex);
        deque.add(startVertex);

        while (!deque.isEmpty()) {
            String currentVertex = deque.pollFirst();
            System.out.print(currentVertex + " ");

            for (String vertex : graph.get(currentVertex)) {
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    deque.add(vertex);
                }
            }
        }
    }

}
