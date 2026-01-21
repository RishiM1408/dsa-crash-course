package com.dsa.graphs;

import java.util.*;

/**
 * Sliding Puzzle (LeetCode 773)
 * 
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5,
 * and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and
 * swapping it.
 * Return the least number of moves to reach [[1,2,3],[4,5,0]].
 * 
 * Strategy: BFS on String state.
 */
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int val : row)
                sb.append(val);
        }
        String start = sb.toString();

        if (start.equals(target))
            return 0;

        // Neighbors for index 0-5 in 2x3 grid
        // 0 1 2
        // 3 4 5
        int[][] directions = {
                { 1, 3 }, // 0
                { 0, 2, 4 }, // 1
                { 1, 5 }, // 2
                { 0, 4 }, // 3
                { 1, 3, 5 }, // 4
                { 2, 4 } // 5
        };

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            moves++;

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                int zeroIdx = curr.indexOf('0');

                for (int nextIdx : directions[zeroIdx]) {
                    String next = swap(curr, zeroIdx, nextIdx);
                    if (next.equals(target))
                        return moves;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
