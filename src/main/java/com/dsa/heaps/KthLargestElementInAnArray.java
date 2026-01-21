package com.dsa.heaps;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array (LeetCode 215)
 * 
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Strategy: Min-Heap of size k.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
