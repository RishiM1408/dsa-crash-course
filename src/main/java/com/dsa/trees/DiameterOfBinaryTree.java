package com.dsa.trees;

/**
 * LeetCode 543: Diameter of Binary Tree
 * Return the length of the diameter of the tree.
 *
 * Pattern: DFS (Post-order)
 * At every node, diameter through it is height(left) + height(right).
 * Update global max. Return 1 + max(left, right) height to parent.
 */
public class DiameterOfBinaryTree {

    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        // Diameter through this node
        maxDiameter = Math.max(maxDiameter, leftH + rightH);

        // Return height
        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solver = new DiameterOfBinaryTree();

        // Test Case 1: [1,2,3,4,5] -> 3 (path 4-2-1-3 or 5-2-1-3)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        System.out.println("Test Case 1: " + (solver.diameterOfBinaryTree(root) == 3 ? "PASS"
                : "FAIL (Got " + solver.diameterOfBinaryTree(root) + ")"));
    }
}
