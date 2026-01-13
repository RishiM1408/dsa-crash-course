package com.dsa.linkedlist;

/**
 * Topic: Linked List (Fast/Slow Pointers)
 * Problem: Reorder List
 * Complexity: O(n) Time | O(1) Space
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + (next != null ? "->" + next : "");
        }
    }

    /**
     * Reorders L0 -> L1 -> ... -> Ln-1 -> Ln
     * to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> ...
     * 
     * Strategy:
     * 1. Find Middle (Fast/Slow Pointers).
     * 2. Reverse the second half of the list.
     * 3. Merge the two halves.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // 1. Find Middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse Second Half
        ListNode second = slow.next;
        slow.next = null; // Cut off the first half
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // 3. Merge
        ListNode first = head;
        second = prev; // Head of reversed list
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        ReorderList solver = new ReorderList();

        // 1->2->3->4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original: " + head);
        solver.reorderList(head);
        System.out.println("Reordered: " + head); // 1->4->2->3
    }
}
