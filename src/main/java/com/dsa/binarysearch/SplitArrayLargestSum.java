package com.dsa.binarysearch;

/**
 * LeetCode 410: Split Array Largest Sum
 *
 * Pattern: Binary Search on Answer
 * Identical to Capacity to Ship Packages logic.
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        long left = 0;
        long right = 0;

        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private boolean canSplit(int[] nums, int k, long limit) {
        int count = 1;
        long currentSum = 0;

        for (int n : nums) {
            if (currentSum + n > limit) {
                count++;
                currentSum = 0;
            }
            currentSum += n;
        }

        return count <= k;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solver = new SplitArrayLargestSum();

        // Test Case 1: [7,2,5,10,8], k=2 -> 18
        int[] nums1 = { 7, 2, 5, 10, 8 };
        System.out.println("Test Case 1: "
                + (solver.splitArray(nums1, 2) == 18 ? "PASS" : "FAIL (Got " + solver.splitArray(nums1, 2) + ")"));
    }
}
