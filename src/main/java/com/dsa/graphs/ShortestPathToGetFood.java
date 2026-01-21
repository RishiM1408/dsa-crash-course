package com.dsa.graphs;

import java.util.*;

/**
 * Shortest Path to Get Food (LeetCode 1730)
 * 
 * You are starving and you want to eat food as quickly as possible. You want to
 * find the shortest path to arrive at any food cell.
 * '*' is your location. '#' is a food cell. 'O' is free space. 'X' is an
 * obstacle.
 * 
 * Strategy: BFS from '*'.
 */
public class ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int steps = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (grid[r][c] == '#')
                    return steps;

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] != 'X') {
                        visited[nr][nc] = true;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
