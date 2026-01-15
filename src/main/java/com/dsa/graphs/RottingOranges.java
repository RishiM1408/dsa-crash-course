package com.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 994: Rotting Oranges
 *
 * Pattern: Multi-source BFS
 * 1. Add all rotten oranges to queue. Count fresh oranges.
 * 2. BFS level by level. Decrement fresh count.
 * 3. Return minutes.
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0)
            return 0;

        int minutes = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAny = false;

            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] { nr, nc });
                        freshCount--;
                        rottedAny = true;
                    }
                }
            }
            if (rottedAny)
                minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();

        // Test Case 1: [[2,1,1],[1,1,0],[0,1,1]] -> 4
        int[][] grid1 = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println("Test Case 1: "
                + (solver.orangesRotting(grid1) == 4 ? "PASS" : "FAIL (Got " + solver.orangesRotting(grid1) + ")"));

        // Test Case 2: [[2,1,1],[0,1,1],[1,0,1]] -> -1
        int[][] grid2 = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println("Test Case 2: "
                + (solver.orangesRotting(grid2) == -1 ? "PASS" : "FAIL (Got " + solver.orangesRotting(grid2) + ")")); // Note:
                                                                                                                      // In-place
                                                                                                                      // mod
                                                                                                                      // affects
                                                                                                                      // test
                                                                                                                      // if
                                                                                                                      // reused,
                                                                                                                      // but
                                                                                                                      // here
                                                                                                                      // new
                                                                                                                      // arrays.
    }
}
