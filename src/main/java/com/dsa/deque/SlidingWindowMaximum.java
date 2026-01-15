package com.dsa.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 239: Sliding Window Maximum
 *
 * Pattern: Monotonic Decreasing Queue
 * Store indices. Remove elements out of window. Maintain decreasing order.
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deque = new ArrayDeque<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Remove indices out of window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();

        // Test Case 1: [1,3,-1,-3,5,3,6,7], k=3 -> [3,3,5,5,6,7]
        int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] res1 = solver.maxSlidingWindow(nums1, 3);
        String expected = "[3, 3, 5, 5, 6, 7]";
        System.out.println("Test Case 1: "
                + (Arrays.toString(res1).equals(expected) ? "PASS" : "FAIL (Got " + Arrays.toString(res1) + ")"));
    }
}
