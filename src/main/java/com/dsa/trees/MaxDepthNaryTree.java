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

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
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
