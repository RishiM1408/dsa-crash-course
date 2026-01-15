package com.dsa.dp;

/**
 * LeetCode 152: Maximum Product Subarray
 *
 * Pattern: DP (Track Min and Max)
 * Since negatives flip sign, max can become min and vice versa.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];
        int min = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = tempMax;

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solver = new MaximumProductSubarray();

        // Test Case 1: [2,3,-2,4] -> 6
        int[] nums1 = { 2, 3, -2, 4 };
        System.out.println("Test Case 1: "
                + (solver.maxProduct(nums1) == 6 ? "PASS" : "FAIL (Got " + solver.maxProduct(nums1) + ")"));

        // Test Case 2: [-2,0,-1] -> 0
        int[] nums2 = { -2, 0, -1 };
        System.out.println("Test Case 2: "
                + (solver.maxProduct(nums2) == 0 ? "PASS" : "FAIL (Got " + solver.maxProduct(nums2) + ")"));
    }
}
