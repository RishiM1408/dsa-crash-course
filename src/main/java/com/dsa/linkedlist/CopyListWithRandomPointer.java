package com.dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 138: Copy List with Random Pointer
 * Construct a deep copy of the list.
 *
 * Pattern: HashMap or Interweaving
 * Approach 1: Map<Node, Node> to map old nodes to new nodes. Two passes.
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        // Pass 1: Create copy nodes and store in map
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Pass 2: Connect next and random pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solver = new CopyListWithRandomPointer();

        // Test Case: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        Node copy = solver.copyRandomList(n0);

        // Verify values and structure
        boolean pass = true;
        if (copy.val != 7 || copy.next.val != 13)
            pass = false;
        if (copy.next.random.val != 7)
            pass = false; // 13.random -> 7
        // Check deep copy (references should be different)
        if (copy == n0)
            pass = false;

        System.out.println("Test Case 1: " + (pass ? "PASS" : "FAIL"));
    }
}
