package inflearn.algorithm.DynamicProgramming.Dijkstra;

import java.util.*;

public class DijkstraAlorithm {

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new int[]{2, 2}, new int[]{1, 4}));
        graph.put(2, Arrays.asList(new int[]{1, 3}, new int[]{9, 5}, new int[]{6, 6}));
        graph.put(3, Arrays.asList(new int[]{4, 6}));
        graph.put(4, Arrays.asList(new int[]{3, 3}, new int[]{5, 7}));
        graph.put(5, Arrays.asList(new int[]{1, 8}));
        graph.put(6, Arrays.asList(new int[]{3, 5}));
        graph.put(7, Arrays.asList(new int[]{7, 6}, new int[]{9, 8}));
        graph.put(8, new ArrayList<>());

        System.out.println(dijkstra(graph, 1, 8));
    }

    public static int dijkstra(Map<Integer, List<int[]>> graph, int start, int finalNode) {
        Map<Integer, Integer> costs = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            System.out.println("pq: " + pq);
            int[] current = pq.poll();
            int curCost = current[0];
            int curV = current[1];

            System.out.println("costs: " + costs);
            System.out.println();

            if (!costs.containsKey(curV)) {
                costs.put(curV, curCost);

                for (int[] edge : graph.get(curV)) {
                    int nextCost = curCost + edge[0];
                    int nextV = edge[1];
                    System.out.println(nextCost + ", " + nextV);
                    pq.add(new int[]{nextCost, nextV});
                }
            }
        }

        return costs.getOrDefault(finalNode, -1); // If final node not reachable, return -1
    }
}
