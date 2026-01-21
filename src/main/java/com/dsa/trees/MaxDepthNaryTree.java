package com.dsa.trees;

import java.util.List;

/**
 * Maximum Depth of N-ary Tree (LeetCode 559)
 * 
 * Given a n-ary tree, find its maximum depth.
 */
public class MaxDepthNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int v) {
            val = v;
        }

        public Node(int v, List<Node> c) {
            val = v;
            children = c;
        }
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int max = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                max = Math.max(max, maxDepth(child));
            }
        }
        return max + 1;
    }
}
