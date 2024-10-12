package inflearn.algorithm.Graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 최단 거리 문제는 BFS로 풀어야 한다.
 * 이유는 DFS는 모든 경로를 탐색하기 때문에 최단 거리를 구할 수는 있으나 시간복잡도 측면에서 비효율적이다.
 * BFS는 가까운 노드부터 탐색하기 때문에 최단 거리를 구할 때 효과적이다.
 */
public class ShortesPathBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };

        System.out.println(shortestPathBinaryMatrix(grid));
    }

    private static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dirs = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0, 0});
        grid[0][0] = 1;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];

            if (x == n - 1 && y == n - 1) {
                return grid[x][y];
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != 0) {
                    continue;
                }

                grid[nx][ny] = grid[x][y] + 1;
                deque.add(new int[]{nx, ny});
            }
        }

        return -1;
    }

}
