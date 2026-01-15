package com.dsa.linkedlist;

/**
 * LeetCode 234: Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 *
 * Pattern: Tortoise & Hare to find Middle + Reverse Second Half
 * 1. Find middle.
 * 2. Reverse second half.
 * 3. Compare two halves.
 * 4. (Optional) Restore list.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode copySecondHalf = secondHalf; // Keep ref to restore if needed

        // 3. Compare
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solver = new PalindromeLinkedList();

        // Test Case 1: [1,2,2,1] -> true
        ListNode l1 = ListNode.fromArray(new int[] { 1, 2, 2, 1 });
        System.out.println("Test Case 1: " + (solver.isPalindrome(l1) ? "PASS" : "FAIL"));

        // Test Case 2: [1,2] -> false
        ListNode l2 = ListNode.fromArray(new int[] { 1, 2 });
        System.out.println("Test Case 2: " + (!solver.isPalindrome(l2) ? "PASS" : "FAIL"));
    }
}
