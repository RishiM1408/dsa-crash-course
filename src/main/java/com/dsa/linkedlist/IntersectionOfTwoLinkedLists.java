package com.dsa.linkedlist;

/**
 * Intersection of Two Linked Lists (LeetCode 160)
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * 
 * Strategy: Two pointers. When one reaches end, switch to other head. They meet
 * at intersection or null.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
