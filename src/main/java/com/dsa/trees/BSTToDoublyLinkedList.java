package com.dsa.trees;

/**
 * Convert Binary Search Tree to Sorted Doubly Linked List (LeetCode 426)
 * 
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in
 * place.
 * The left and right pointers of each node are to be used as the predecessor
 * and successor references in the doubly linked list.
 */
public class BSTToDoublyLinkedList {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        helper(root);

        // Close the circle
        last.right = first;
        first.left = last;

        return first;
    }

    private void helper(Node node) {
        if (node == null)
            return;

        helper(node.left);

        if (last != null) {
            // Link previous node (last) with current (node)
            last.right = node;
            node.left = last;
        } else {
            // Keep the smallest node as head
            first = node;
        }
        last = node;

        helper(node.right);
    }
}
