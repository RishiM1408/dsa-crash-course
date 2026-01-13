package com.dsa.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Topic: Monotonic Queue (Deque)
 * Problem: Sliding Window Maximum
 * Pattern: Monotonic Decreasing Deque (Indices)
 * Complexity: O(n) Time | O(k) Space
 */
public class SlidingWindowMaximum {

    /**
     * Finds the max element in each sliding window of size k.
     * 
     * Logic:
     * We need a data structure that:
     * 1. Maintains elements in decreasing order (so First is always Max).
     * 2. Supports adding from back and removing from back (to maintain order).
     * 3. Supports removing from front (when element goes out of window).
     * -> Deque (Doubly Ended Queue).
     * 
     * Steps:
     * 1. Iterate 'i' from 0 to n.
     * 2. Remove indices from front that are out of window bound (i - k).
     * 3. Remove indices from back whose values are < nums[i] (Because nums[i] is
     * newer and larger).
     * 4. Add 'i' to back.
     * 5. If i >= k-1, add nums[deque.peekFirst()] to result.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Stores INDICES
        int ri = 0;

        for (int i = 0; i < n; i++) {
            // 1. Remove out of bound indices
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 2. Remove smaller elements from back (Maintain Monotonic Decreasing)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(i);

            // 4. Record result
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();

        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        // Window 1: [1, 3, -1] -> 3
        // Window 2: [3, -1, -3] -> 3
        // Window 3: [-1, -3, 5] -> 5
        // Window 4: [-3, 5, 3] -> 5
        // Window 5: [5, 3, 6] -> 6
        // Window 6: [3, 6, 7] -> 7

        System.out.println("Max Sliding Window: " + Arrays.toString(solver.maxSlidingWindow(nums, k)));
        // Expected: [3, 3, 5, 5, 6, 7]
    }
}
