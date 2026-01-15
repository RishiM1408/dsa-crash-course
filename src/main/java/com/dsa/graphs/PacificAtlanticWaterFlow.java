package com.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 417: Pacific Atlantic Water Flow
 *
 * Pattern: DFS from Borders
 * 1. DFS from Pacific borders (top, left) -> maintain boolean[][]
 * pacificReachable.
 * 2. DFS from Atlantic borders (bottom, right) -> maintain boolean[][]
 * atlanticReachable.
 * 3. Intersection is result.
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0)
            return result;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Left and Right cols
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }

        // DFS from Top and Bottom rows
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int r, int c, int prevHeight) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || reachable[r][c]
                || heights[r][c] < prevHeight) {
            return;
        }
        reachable[r][c] = true;

        dfs(heights, reachable, r + 1, c, heights[r][c]);
        dfs(heights, reachable, r - 1, c, heights[r][c]);
        dfs(heights, reachable, r, c + 1, heights[r][c]);
        dfs(heights, reachable, r, c - 1, heights[r][c]);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();

        // Test Case 1
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        List<List<Integer>> res = solver.pacificAtlantic(heights);
        // Expect 7 cells: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]] order may vary
        System.out.println("Test Case 1: " + (res.size() == 7 ? "PASS" : "FAIL (Got size " + res.size() + ")"));
    }
}
