package inflearn.algorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph = new int[][]{{1, 2, 3},{0, 2},{0, 1, 3},{0, 2}};
        System.out.println(isBipartite(graph));
    }

    // Time complexity: O(V + E)
    // Space complexity: O(V)
    private static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
//            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
            if (colors[i] == 0 && !bfs(graph, colors, i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean bfs(int[][] graph, int[] colors, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (colors[next] == 0) {
                    colors[next] = -colors[current];
                    queue.offer(next);
                } else if (colors[next] == colors[current]) {
                    return false;
                }
            }
        }

        return true;
    }

//    private static boolean dfs(int[][] graph, int[] colors, int node, int color) {
//        if (colors[node] != 0) {
//            return colors[node] == color;
//        }
//
//        colors[node] = color;
//
//        for (int next : graph[node]) {
//            if (!dfs(graph, colors, next, -color)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

}
