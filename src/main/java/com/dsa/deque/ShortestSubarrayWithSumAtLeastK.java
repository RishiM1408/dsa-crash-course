package com.dsa.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 862: Shortest Subarray with Sum at Least K
 *
 * Pattern: Prefix Sum + Monotonic Increasing Deque
 * Optimize finding smallest j > i such that P[j] - P[i] >= K.
 */
public class ShortestSubarrayWithSumAtLeastK {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] P = new long[n + 1];
        for (int i = 0; i < n; i++)
            P[i + 1] = P[i] + nums[i];

        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = n + 1;

        for (int y = 0; y <= n; y++) {
            // Check if P[y] - P[x] >= K
            while (!deque.isEmpty() && P[y] - P[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, y - deque.pollFirst());
            }

            // Maintain increasing order of P[x]
            while (!deque.isEmpty() && P[y] <= P[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(y);
        }

        return minLen <= n ? minLen : -1;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK solver = new ShortestSubarrayWithSumAtLeastK();

        // Test Case 1: [1], k=1 -> 1
        System.out.println("Test Case 1: " + (solver.shortestSubarray(new int[] { 1 }, 1) == 1 ? "PASS" : "FAIL"));

        // Test Case 2: [1,2], k=4 -> -1
        System.out.println("Test Case 2: " + (solver.shortestSubarray(new int[] { 1, 2 }, 4) == -1 ? "PASS" : "FAIL"));

        // Test Case 3: [2,-1,2], k=3 -> 3
        System.out
                .println("Test Case 3: " + (solver.shortestSubarray(new int[] { 2, -1, 2 }, 3) == 3 ? "PASS" : "FAIL"));

        // Test Case 4: [84, -37, 32, 40, 95], k=167 -> 3 (32+40+95 = 167)
        int[] t4 = { 84, -37, 32, 40, 95 };
        System.out.println("Test Case 4: " + (solver.shortestSubarray(t4, 167) == 3 ? "PASS"
                : "FAIL (Got " + solver.shortestSubarray(t4, 167) + ")"));
    }
}
