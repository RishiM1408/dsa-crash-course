package com.dsa.graphs;

import java.util.*;

/**
 * Walls and Gates (LeetCode 286)
 * 
 * Fill each empty room with the distance to its nearest gate.
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room.
 * 
 * Multi-source BFS from all Gates.
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0)
            return;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[nr][nc] == Integer.MAX_VALUE) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
    }
}
