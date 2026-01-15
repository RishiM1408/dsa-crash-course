package com.dsa.trees;

/**
 * LeetCode 98: Validate Binary Search Tree
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 *
 * Pattern: Recursion with Range
 * Validate that left child < root < right child, recursively passing down
 * min/max constraints.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solver = new ValidateBinarySearchTree();

        // Test Case 1: [2,1,3] -> true
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Test Case 1: " + (solver.isValidBST(root1) ? "PASS" : "FAIL"));

        // Test Case 2: [5,1,4,null,null,3,6] -> false (3 is in right subtree of 5 but <
        // 5? No wait, 4 is > 5? No.)
        // LeetCode Example: root = [5,1,4,null,null,3,6] (3 and 6 are children of 4).
        // Tree:
        // 5
        // / \
        // 1 4
        // / \
        // 3 6
        // Fail because 4 < 5 but is on right. ALSO 3 < 5 but in right subtree.
        // Wait, normally right child must be > root. 4 < 5 so it shouldn't be on right.
        // Oh, the array representation...
        // Let's manually build invalid tree: 5, left 1, right 4. 4 has children 3, 6.
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println("Test Case 2: " + (!solver.isValidBST(root2) ? "PASS" : "FAIL"));
    }
}
