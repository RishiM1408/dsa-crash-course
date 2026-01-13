package com.dsa.graphs;

/**
 * Topic: Graphs (Union-Find)
 * Problem: Number of Connected Components (Number of Provinces)
 * Complexity: O(n^2) Time | O(n) Space
 */
public class NumberOfProvinces {

    /**
     * Finds the number of connected components.
     * Uses Union-Find data structure.
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }

    // Inner class for Union-Find
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]); // Path compression
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces solver = new NumberOfProvinces();

        int[][] isConnected = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("Provinces: " + solver.findCircleNum(isConnected));
        // Expected: 2 (Provinces: {0,1}, {2})
    }
}
