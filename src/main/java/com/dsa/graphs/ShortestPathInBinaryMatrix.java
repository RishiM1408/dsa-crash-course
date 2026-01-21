package com.dsa.graphs;

import java.util.*;

/**
 * Shortest Path in Binary Matrix (LeetCode 1091)
 * 
 * In an N x N square grid, each cell is either empty (0) or blocked (1).
 * Return the length of the shortest clear path from top-left to bottom-right
 * such that the path visits cells in 8 directions.
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { 0, 0 });
        visited[0][0] = true;
        int pathLen = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == n - 1 && c == n - 1)
                    return pathLen;

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
            pathLen++;
        }
        return -1;
    }
}
