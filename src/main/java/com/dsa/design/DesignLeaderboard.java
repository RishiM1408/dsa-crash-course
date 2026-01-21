package com.dsa.design;

import java.util.*;

/**
 * Design Leaderboard (LeetCode 1244)
 * 
 * Design a Leaderboard class, which has 3 functions:
 * 1. addScore(playerId, score): Update the leaderboard by adding score to the
 * given player's score. If player doesn't exist, he starts with 0.
 * 2. top(K): Return the sum of scores of the top K players.
 * 3. reset(playerId): Reset the score of the player with the given id to 0.
 * 
 * Strategy: Map<PlayerId, Score> to store current scores.
 * For top(K), we can sort the values or use a Min-Heap/QuickSelect. Since K is
 * likely small relative to N, or N is small (10^4 ops), sorting O(N log N) is
 * acceptable or heap O(N log K).
 */
public class DesignLeaderboard {

    private Map<Integer, Integer> scores;

    public DesignLeaderboard() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public int top(int k) {
        // Efficiency note: For very large N, a TreeMap or PriorityQueue kept in sync
        // would be faster.
        // For typical constraints, extracting values and sorting is simple and passes.
        List<Integer> values = new ArrayList<>(scores.values());
        Collections.sort(values, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < k && i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum;
    }

    public void reset(int playerId) {
        scores.remove(playerId);
    }
}
