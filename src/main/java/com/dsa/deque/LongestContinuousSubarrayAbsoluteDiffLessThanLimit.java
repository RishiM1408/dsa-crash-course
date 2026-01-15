package com.dsa.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 1438: Longest Continuous Subarray With Absolute Diff Less Than or
 * Equal to Limit
 *
 * Pattern: Two Monotonic Deques (Min and Max)
 * Maintain min and max in current window.
 * While max - min > limit, shrink window from left.
 */
public class LongestContinuousSubarrayAbsoluteDiffLessThanLimit {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxD.isEmpty() && maxD.peekLast() < nums[right])
                maxD.pollLast();
            while (!minD.isEmpty() && minD.peekLast() > nums[right])
                minD.pollLast();

            maxD.offerLast(nums[right]);
            minD.offerLast(nums[right]);

            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (maxD.peekFirst() == nums[left])
                    maxD.pollFirst();
                if (minD.peekFirst() == nums[left])
                    minD.pollFirst();
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestContinuousSubarrayAbsoluteDiffLessThanLimit solver = new LongestContinuousSubarrayAbsoluteDiffLessThanLimit();

        // Test Case 1: [8,2,4,7], limit=4 -> 2 ([2,4] or [4,7])
        int[] nums1 = { 8, 2, 4, 7 };
        System.out.println("Test Case 1: " + (solver.longestSubarray(nums1, 4) == 2 ? "PASS"
                : "FAIL (Got " + solver.longestSubarray(nums1, 4) + ")"));

        // Test Case 2: [10,1,2,4,7,2], limit=5 -> 4 ([2,4,7,2])
        int[] nums2 = { 10, 1, 2, 4, 7, 2 };
        System.out.println("Test Case 2: " + (solver.longestSubarray(nums2, 5) == 4 ? "PASS"
                : "FAIL (Got " + solver.longestSubarray(nums2, 5) + ")"));
    }
}
