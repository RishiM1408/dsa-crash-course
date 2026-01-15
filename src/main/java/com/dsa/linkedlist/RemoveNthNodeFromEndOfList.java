package com.dsa.linkedlist;

/**
 * LeetCode 19: Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 *
 * Pattern: Two Pointers (Gap method)
 * Move fast pointer n steps ahead. Then move both until fast reaches end.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast n+1 steps ahead so slow ends up at node BEFORE the target
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solver = new RemoveNthNodeFromEndOfList();

        // Test Case 1: [1,2,3,4,5], n = 2 -> [1,2,3,5]
        ListNode l1 = ListNode.fromArray(new int[] { 1, 2, 3, 4, 5 });
        ListNode res1 = solver.removeNthFromEnd(l1, 2);
        System.out.println("Test Case 1: " + (ListNode.toString(res1).equals("[1,2,3,5]") ? "PASS"
                : "FAIL (Got " + ListNode.toString(res1) + ")"));

        // Test Case 2: [1], n = 1 -> []
        ListNode l2 = ListNode.fromArray(new int[] { 1 });
        ListNode res2 = solver.removeNthFromEnd(l2, 1);
        System.out.println("Test Case 2: "
                + (ListNode.toString(res2).equals("[]") ? "PASS" : "FAIL (Got " + ListNode.toString(res2) + ")"));

        // Test Case 3: [1,2], n = 1 -> [1]
        ListNode l3 = ListNode.fromArray(new int[] { 1, 2 });
        ListNode res3 = solver.removeNthFromEnd(l3, 1);
        System.out.println("Test Case 3: "
                + (ListNode.toString(res3).equals("[1]") ? "PASS" : "FAIL (Got " + ListNode.toString(res3) + ")"));
    }
}
