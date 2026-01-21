package com.dsa.graphs;

import java.util.*;

/**
 * Evaluate Division (LeetCode 399)
 * 
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i].
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 * 
 * Strategy: Graph DFS/BFS. a->b = val, b->a = 1/val. Find path product.
 */
public class EvaluateDivision {

    class Node {
        String key;
        double val;

        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, val));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Node(u, 1.0 / val));
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                ans[i] = -1.0;
            } else if (u.equals(v)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(u, v, new HashSet<>(), graph);
            }
        }
        return ans;
    }

    private double dfs(String curr, String target, Set<String> visited, Map<String, List<Node>> graph) {
        if (curr.equals(target))
            return 1.0;
        visited.add(curr);

        for (Node neighbor : graph.get(curr)) {
            if (!visited.contains(neighbor.key)) {
                double res = dfs(neighbor.key, target, visited, graph);
                if (res != -1.0) {
                    return res * neighbor.val;
                }
            }
        }
        return -1.0;
    }
}
