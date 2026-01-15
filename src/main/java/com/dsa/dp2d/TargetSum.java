package com.dsa.dp2d;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 494: Target Sum
 *
 * Pattern: DP with Memoization (or 0/1 Knapsack variation)
 * Ways to assign + or - to make sum S.
 */
public class TargetSum {

    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return calculate(nums, 0, 0, target);
    }

    private int calculate(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = i + "," + sum;
        if (memo.containsKey(key))
            return memo.get(key);

        int add = calculate(nums, i + 1, sum + nums[i], target);
        int subtract = calculate(nums, i + 1, sum - nums[i], target);

        memo.put(key, add + subtract);
        return add + subtract;
    }

    public static void main(String[] args) {
        TargetSum solver = new TargetSum();

        // Test Case 1: [1,1,1,1,1], target=3 -> 5
        int[] nums1 = { 1, 1, 1, 1, 1 };
        System.out.println("Test Case 1: " + (solver.findTargetSumWays(nums1, 3) == 5 ? "PASS" : "FAIL"));
    }
}
