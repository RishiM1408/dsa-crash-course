package com.dsa.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 23: Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Pattern: Min Heap
 * Add head of each list to heap. Poll min, add next of polled node to heap.
 * Time: O(N log k) where N is total nodes.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solver = new MergeKSortedLists();

        // Test Case 1: [[1,4,5],[1,3,4],[2,6]] -> [1,1,2,3,4,4,5,6]
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.fromArray(new int[] { 1, 4, 5 });
        lists[1] = ListNode.fromArray(new int[] { 1, 3, 4 });
        lists[2] = ListNode.fromArray(new int[] { 2, 6 });

        ListNode res = solver.mergeKLists(lists);
        String expected = "[1,1,2,3,4,4,5,6]";
        System.out.println("Test Case 1: "
                + (ListNode.toString(res).equals(expected) ? "PASS" : "FAIL (Got " + ListNode.toString(res) + ")"));

        // Test Case 2: [] -> []
        System.out.println("Test Case 2: " + (solver.mergeKLists(new ListNode[0]) == null ? "PASS" : "FAIL"));
    }
}
