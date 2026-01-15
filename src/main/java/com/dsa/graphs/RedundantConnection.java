package com.dsa.graphs;

import java.util.Arrays;

/**
 * LeetCode 684: Redundant Connection
 * Return an edge that can be removed so that the resulting graph is a tree of N
 * nodes.
 *
 * Pattern: Union-Find (Disjoint Set)
 * Iterate edges. If u and v already connected, this edge is redundant.
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (find(parent, u) == find(parent, v)) {
                return edge;
            } else {
                union(parent, u, v);
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

    public static void main(String[] args) {
        RedundantConnection solver = new RedundantConnection();

        // Test Case 1: [[1,2],[1,3],[2,3]] -> [2,3]
        int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] res1 = solver.findRedundantConnection(edges1);
        System.out.println("Test Case 1: "
                + (Arrays.toString(res1).equals("[2, 3]") ? "PASS" : "FAIL (Got " + Arrays.toString(res1) + ")"));
    }
}
