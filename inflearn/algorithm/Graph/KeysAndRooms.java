package inflearn.algorithm.Graph;

import java.util.*;

public class KeysAndRooms {

    public static void main (String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        bfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        if (visited[room]) return;
        visited[room] = true;
        for (int key : rooms.get(room)) {
            dfs(rooms, key, visited);
        }
    }

    private static void bfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(room);
        visited[room] = true;
        while (!queue.isEmpty()) {
            int r = queue.poll();
            for (int key : rooms.get(r)) {
                if (!visited[key]) {
                    queue.offer(key);
                    visited[key] = true;
                }
            }
        }
    }
}
