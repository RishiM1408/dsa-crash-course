package com.dsa.slidingwindow;

/**
 * LeetCode 1004: Max Consecutive Ones III
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's.
 *
 * Pattern: Sliding Window
 * We need to find the longest subarray that contains at most k zeros.
 * 
 * Approach:
 * 1. Expand 'right' pointer. If we encounter a 0, increment zeroCount.
 * 2. If zeroCount > k, shrink from 'left' until zeroCount <= k.
 * 3. Update maxLen = max(maxLen, right - left + 1).
 * 
 * Time: O(n), Space: O(1)
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        int zeroCount = 0;
        int maxLen = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // While window is invalid (more than k zeros)
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII solver = new MaxConsecutiveOnesIII();

        // Test Case 1: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 -> 6
        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        System.out.println("Test Case 1: "
                + (solver.longestOnes(nums1, 2) == 6 ? "PASS" : "FAIL (Got " + solver.longestOnes(nums1, 2) + ")"));

        // Test Case 2: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 -> 10
        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println("Test Case 2: "
                + (solver.longestOnes(nums2, 3) == 10 ? "PASS" : "FAIL (Got " + solver.longestOnes(nums2, 3) + ")"));

        // Test Case 3: nums = [0,0,0,0], k = 0 -> 0
        int[] nums3 = { 0, 0, 0, 0 };
        System.out.println("Test Case 3: "
                + (solver.longestOnes(nums3, 0) == 0 ? "PASS" : "FAIL (Got " + solver.longestOnes(nums3, 0) + ")"));
    }
}
