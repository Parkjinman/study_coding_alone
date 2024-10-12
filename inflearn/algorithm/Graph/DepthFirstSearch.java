package inflearn.algorithm.Graph;

import java.util.*;

public class DepthFirstSearch {
    static Map<String, List<String>> graph = new HashMap<>() {{
        put("A", Arrays.asList("B", "D", "E"));
        put("B", Arrays.asList("A", "C", "D"));
        put("C", Arrays.asList("B"));
        put("D", Arrays.asList("A", "B"));
        put("E", Arrays.asList("A"));
    }};
    static ArrayList<String> visited = new ArrayList<>();

    public static void main(String[] args) {

        dfs("A");
    }

    private static void dfs(String startVertex) {
        visited.add(startVertex);
        System.out.print(startVertex + " ");

        for (String vertex : graph.get(startVertex)) {
            if (!visited.contains(vertex)) {
                dfs(vertex);
            }
        }
    }

}
