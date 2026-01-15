package com.dsa.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Pattern: Recursion + HashMap
 * Preorder: [Root, Left, Right]
 * Inorder: [Left, Root, Right]
 * 1. Root is first in Preorder.
 * 2. Find Root index in Inorder. Use Map for O(1).
 * 3. Recursively build left and right.
 */
public class ConstructBinaryTreePreIn {

    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

    // Helper to print inorder for verification
    private static void printInorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        printInorder(root.left, sb);
        sb.append(root.val).append(" ");
        printInorder(root.right, sb);
    }

    public static void main(String[] args) {
        ConstructBinaryTreePreIn solver = new ConstructBinaryTreePreIn();

        // Test Case 1: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // Tree: 3 -> left(9), right(20->left(15),right(7))
        int[] pre = { 3, 9, 20, 15, 7 };
        int[] in = { 9, 3, 15, 20, 7 };
        TreeNode root = solver.buildTree(pre, in);

        StringBuilder sb = new StringBuilder();
        printInorder(root, sb);
        String res = sb.toString().trim();
        // Inorder of constructed tree should match input inorder (mostly)
        System.out.println("Test Case 1: " + (res.equals("9 3 15 20 7") ? "PASS" : "FAIL (Got " + res + ")"));
    }
}
