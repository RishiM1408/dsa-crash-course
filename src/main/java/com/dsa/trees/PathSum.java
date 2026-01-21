package com.dsa.trees;

/**
 * Path Sum (LeetCode 112)
 * 
 * Given the root of a binary tree and an integer targetSum, return true if the
 * tree has a root-to-leaf path such that adding up all the values along the
 * path equals targetSum.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        // Check leaf
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
