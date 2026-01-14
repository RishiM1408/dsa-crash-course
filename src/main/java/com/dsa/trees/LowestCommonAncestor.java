package com.dsa.trees;

/**
 * Topic: Trees (DFS/BFS)
 * Problem: Lowest Common Ancestor of a Binary Search Tree
 * LeetCode: 235
 * Complexity: O(h) Time | O(1) Space
 */
public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    /**
     * Finds the LCA of two nodes in a BST.
     * 
     * Logic:
     * We use the property of BST: Left < Root < Right.
     * 1. If both p and q are smaller than root, LCA is in the left subtree.
     * 2. If both p and q are larger than root, LCA is in the right subtree.
     * 3. Otherwise (split occurs), the root is the LCA.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor solver = new LowestCommonAncestor();

        // 6
        // / \
        // 2 8
        // / \ / \
        // 0 4 7 9

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left; // 2
        TreeNode q = root.right; // 8
        System.out.println("LCA of 2 and 8: " + solver.lowestCommonAncestor(root, p, q)); // 6

        p = root.left; // 2
        q = root.left.right; // 4
        System.out.println("LCA of 2 and 4: " + solver.lowestCommonAncestor(root, p, q)); // 2
    }
}
