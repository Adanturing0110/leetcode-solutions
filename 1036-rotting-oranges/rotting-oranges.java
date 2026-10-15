import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        // Step 1: collect all rotten oranges, count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0; // nothing to rot

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        // Step 2: BFS level by level (each level = 1 minute)
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;   // rot it
                        fresh--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            minutes++;
        }

        // Step 3: anything still fresh is unreachable
        return fresh == 0 ? minutes : -1;
    }
}