package inflearn.algorithm.Graph;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfIslandsBFS {

    static char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    public static void main(String[] args) {
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int i, int j) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{i, j});

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0') {
                continue;
            }

            grid[x][y] = '0';

            deque.add(new int[]{x - 1, y});
            deque.add(new int[]{x + 1, y});
            deque.add(new int[]{x, y - 1});
            deque.add(new int[]{x, y + 1});
        }
    }

}
