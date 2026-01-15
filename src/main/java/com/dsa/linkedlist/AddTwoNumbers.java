package com.dsa.linkedlist;

/**
 * LeetCode 2: Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order.
 * Add the two numbers and return the sum as a linked list.
 *
 * Pattern: Math Simulation
 * Iterate both lists, track carry.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solver = new AddTwoNumbers();

        // Test Case 1: [2,4,3] + [5,6,4] = [7,0,8] (342 + 465 = 807)
        ListNode l1 = ListNode.fromArray(new int[] { 2, 4, 3 });
        ListNode l2 = ListNode.fromArray(new int[] { 5, 6, 4 });
        ListNode res1 = solver.addTwoNumbers(l1, l2);
        System.out.println("Test Case 1: "
                + (ListNode.toString(res1).equals("[7,0,8]") ? "PASS" : "FAIL (Got " + ListNode.toString(res1) + ")"));

        // Test Case 2: [9,9,9,9,9,9,9] + [9,9,9,9]
        ListNode l3 = ListNode.fromArray(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l4 = ListNode.fromArray(new int[] { 9, 9, 9, 9 });
        ListNode res2 = solver.addTwoNumbers(l3, l4);
        // 9999999 + 9999 = 10009998 -> [8,9,9,9,0,0,0,1]
        String expected = "[8,9,9,9,0,0,0,1]";
        System.out.println("Test Case 2: "
                + (ListNode.toString(res2).equals(expected) ? "PASS" : "FAIL (Got " + ListNode.toString(res2) + ")"));
    }
}
