package com.dsa.trees;

/**
 * Topic: Tree Refinement (Generic Binary Tree)
 * Problem: Lowest Common Ancestor of a Binary Tree
 * Complexity: O(n) Time | O(n) Space
 */
public class LowestCommonAncestorGeneric {

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
     * Finds the LCA of two nodes in a Generic Binary Tree (Not BST).
     * 
     * Logic:
     * 1. If root is null or root matches p or q, returning root.
     * 2. Recurse left and right.
     * 3. If both left and right return non-null, it means we found p in one subtree
     * and q in the other. Therefore, current root is the LCA.
     * 4. If only one side returns non-null, propagate that result up.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestorGeneric solver = new LowestCommonAncestorGeneric();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1
        System.out.println("LCA of 5 and 1: " + solver.lowestCommonAncestor(root, p, q)); // 3

        p = root.left; // 5
        q = root.left.right; // 2
        System.out.println("LCA of 5 and 2: " + solver.lowestCommonAncestor(root, p, q)); // 5
    }
}
