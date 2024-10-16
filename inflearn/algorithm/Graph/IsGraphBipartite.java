package inflearn.algorithm.Graph;

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

        // 0: not colored, 1: red, -1: blue
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int next : graph[node]) {
            if (!dfs(graph, colors, next, -color)) {
                return false;
            }
        }

        return true;
    }

}
