package inflearn.algorithm.DynamicProgramming.Dijkstra;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = new int[][]{{2, 1, 2}, {2, 3, 5}, {2, 4, 1}, {4, 3, 3}};
        int N = 4;
        int K = 2;

//        int N = 4;
//        int K = 3;
        System.out.println(networkDelayTime(times, N, K));
    }

    /**
     * 네트워크 지연시간
     * - times: 각 노드간의 거리와 시간
     * - N: 노드의 개수
     * - K: 시작 노드
     */
    public static int networkDelayTime(int[][] times, int N, int K) {
        // 그래프 구현
        Map<Integer, List<int[]>> graph = createGraph(times);
        System.out.println(graphToString(graph));

        // 최단거리 구하기
        Map<Integer, Integer> result = dijkstra(graph, K);
        System.out.println(result);

        // 방문 못한 노드 찾기
        if (result.size() != N) {
            return -1;
        }

        // 최소값중에서 최대값 구하기
        return Math.max(0, result.values().stream().mapToInt(Integer::intValue).max().getAsInt());
    }

    /**
     * 그래프 출력
     * @param graph Map<Integer, List<int[]>>
     * @return String
     */
    private static String graphToString(Map<Integer, List<int[]>> graph) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            sb.append(entry.getKey()).append(": ");
            for (int[] edge : entry.getValue()) {
                sb.append(Arrays.toString(edge)).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * 그래프 생성
     * @param times int[][]
     * @return Map<Integer, List<int[]>>
     */
    private static Map<Integer, List<int[]>> createGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0];
            int v = time[2];
            int w = time[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        return graph;
    }

    /**
     * 다익스트라 알고리즘
     * @param graph Map<Integer, List<int[]>>
     * @param start int
     * @return int
     */
    private static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int start) {
        Map<Integer, Integer> costs = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curCost = current[0];
            int curNode = current[1];

            if (!costs.containsKey(curNode)) {
                costs.put(curNode, curCost);
                if (!graph.containsKey(curNode)) {
                    continue;
                }

                for (int[] edge : graph.get(curNode)) {
                    int nextCost = curCost + edge[0];
                    int nextNode = edge[1];
                    pq.add(new int[]{nextCost, nextNode});
                }
            }
        }

        return costs;
    }

//    public static int networkDelayTime(int[][] times, int N, int K) {
//        int[][] graph = new int[N + 1][N + 1];
//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < N + 1; j++) {
//                graph[i][j] = -1;
//            }
//        }
//
//        for (int[] time : times) {
//            graph[time[0]][time[1]] = time[2];
//        }
//
//        int[] costs = new int[N + 1];
//        for (int i = 0; i < N + 1; i++) {
//            costs[i] = Integer.MAX_VALUE;
//        }
//        costs[K] = 0;
//
//        boolean[] visited = new boolean[N + 1];
//
//        for (int i = 1; i < N + 1; i++) {
//            int minCost = Integer.MAX_VALUE;
//            int minNode = -1;
//
//            for (int j = 1; j < N + 1; j++) {
//                if (!visited[j] && costs[j] < minCost) {
//                    minCost = costs[j];
//                    minNode = j;
//                }
//            }
//
//            visited[minNode] = true;
//
//            for (int j = 1; j < N + 1; j++) {
//                if (graph[minNode][j] != -1) {
//                    costs[j] = Math.min(costs[j], costs[minNode] + graph[minNode][j]);
//                }
//            }
//        }
//
//        int max = 0;
//        for (int i = 1; i < N + 1; i++) {
//            if (costs[i] == Integer.MAX_VALUE) {
//                return -1;
//            }
//            max = Math.max(max, costs[i]);
//        }
//
//        return max;
//    }

}
