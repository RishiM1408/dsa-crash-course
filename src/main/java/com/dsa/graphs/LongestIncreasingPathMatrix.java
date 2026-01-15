package com.dsa.graphs;

/**
 * LeetCode 329: Longest Increasing Path in a Matrix
 *
 * Pattern: DFS + Memoization
 * From each cell, DFS to find max increasing path starting there. Memoize
 * result.
 */
public class LongestIncreasingPathMatrix {

    private int[][] memo;
    private int m, n;
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c) {
        if (memo[r][c] != 0)
            return memo[r][c];

        int max = 1;
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(matrix, nr, nc));
            }
        }

        memo[r][c] = max;
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix solver = new LongestIncreasingPathMatrix();

        // Test Case 1: [[9,9,4],[6,6,8],[2,1,1]] -> 4 (1-2-6-9)
        int[][] grid1 = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println("Test Case 1: " + (solver.longestIncreasingPath(grid1) == 4 ? "PASS"
                : "FAIL (Got " + solver.longestIncreasingPath(grid1) + ")"));

        // Test Case 2: [[3,4,5],[3,2,6],[2,2,1]] -> 4 (3-4-5-6)
        int[][] grid2 = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
        System.out.println("Test Case 2: " + (solver.longestIncreasingPath(grid2) == 4 ? "PASS"
                : "FAIL (Got " + solver.longestIncreasingPath(grid2) + ")"));
    }
}
