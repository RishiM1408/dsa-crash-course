package com.dsa.trees;

import java.util.*;

/**
 * Binary Tree Zigzag Level Order Traversal (LeetCode 103)
 * 
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values.
 * (i.e., from left to right, then right to left for the next level and
 * alternate between).
 * 
 * Strategy: BFS with a deque or Collections.reverse.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (!leftToRight) {
                Collections.reverse(level);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
