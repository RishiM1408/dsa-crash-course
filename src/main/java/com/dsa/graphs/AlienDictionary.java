package com.dsa.graphs;

import java.util.*;

/**
 * LeetCode 269: Alien Dictionary
 *
 * Pattern: Graph Building + Topological Sort
 * 1. Compare adjacent words to find first differing character. Edge U->V.
 * 2. Build graph and indegree.
 * 3. Topological sort.
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize indegree map for all characters
        for (String w : words) {
            for (char c : w.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Check prefix edge case: if w2 is prefix of w1 and w2 < w1 length, invalid.
            // Example: ["abc", "ab"] -> invalid because "ab" should assume "abc" but it
            // comes later.
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return ""; // Invalid order
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.putIfAbsent(c1, new ArrayList<>());
                    adj.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break; // Only first difference matters
                }
            }
        }

        // Topo Sort
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);

            if (adj.containsKey(curr)) {
                for (char neighbor : adj.get(curr)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        if (sb.length() < indegree.size())
            return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary solver = new AlienDictionary();

        // Test Case 1: ["wrt","wrf","er","ett","rftt"] -> "wertf"
        String[] w1 = { "wrt", "wrf", "er", "ett", "rftt" };
        String res1 = solver.alienOrder(w1);
        System.out.println("Test Case 1: " + (res1.equals("wertf") ? "PASS" : "FAIL (Got " + res1 + ")"));

        // Test Case 2: ["z","x","z"] -> ""
        String[] w2 = { "z", "x", "z" };
        System.out.println("Test Case 2: "
                + (solver.alienOrder(w2).equals("") ? "PASS" : "FAIL (Got " + solver.alienOrder(w2) + ")"));
    }
}
