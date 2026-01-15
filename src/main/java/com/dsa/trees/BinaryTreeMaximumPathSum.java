package com.dsa.trees;

/**
 * LeetCode 124: Binary Tree Maximum Path Sum
 *
 * Pattern: DFS with Global Max
 * For each node, max path passing through it is node.val + max(0, leftMax) +
 * max(0, rightMax).
 * Return node.val + max(0, leftMax, rightMax) to parent.
 */
public class BinaryTreeMaximumPathSum {

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxPathSum;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null)
            return 0;

        // Ignore negative paths (take 0 instead)
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        // Update global max (path through this node)
        maxPathSum = Math.max(maxPathSum, node.val + left + right);

        // Return max path ending at this node to parent
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solver = new BinaryTreeMaximumPathSum();

        // Test Case 1: [1,2,3] -> 6
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 1: "
                + (solver.maxPathSum(root1) == 6 ? "PASS" : "FAIL (Got " + solver.maxPathSum(root1) + ")"));

        // Test Case 2: [-10,9,20,null,null,15,7] -> 42
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println("Test Case 2: "
                + (solver.maxPathSum(root2) == 42 ? "PASS" : "FAIL (Got " + solver.maxPathSum(root2) + ")"));
    }
}
