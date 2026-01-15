package com.dsa.dp;

/**
 * LeetCode 198: House Robber
 *
 * Pattern: DP 1D
 * dp[i] = max amount robbed up to house i.
 * dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber solver = new HouseRobber();

        // Test Case 1: [1,2,3,1] -> 4 (1+3)
        int[] nums1 = { 1, 2, 3, 1 };
        System.out
                .println("Test Case 1: " + (solver.rob(nums1) == 4 ? "PASS" : "FAIL (Got " + solver.rob(nums1) + ")"));

        // Test Case 2: [2,7,9,3,1] -> 12 (2+9+1)
        int[] nums2 = { 2, 7, 9, 3, 1 };
        System.out
                .println("Test Case 2: " + (solver.rob(nums2) == 12 ? "PASS" : "FAIL (Got " + solver.rob(nums2) + ")"));
    }
}
