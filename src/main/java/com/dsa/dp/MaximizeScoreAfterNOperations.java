package com.dsa.dp;

import java.util.*;

/**
 * Maximize Score After N Operations (LeetCode 1799)
 * 
 * You are given nums, an array of positive integers of size 2 * n. You must
 * perform n operations on this array.
 * In the i-th operation (1-indexed), you will:
 * Choose two elements x and y.
 * Receive a score of i * gcd(x, y).
 * Remove x and y from nums.
 * Return the maximum score you can receive after performing n operations.
 * 
 * Strategy: DP with Bitmask.
 * State: mask (representing available numbers).
 * Range of n is small (1 <= n <= 7), so mask up to 2^14.
 */
public class MaximizeScoreAfterNOperations {

    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1);
        return backtrack(nums, 0, 1, memo);
    }

    private int backtrack(int[] nums, int mask, int op, int[] memo) {
        if (op > nums.length / 2)
            return 0;
        if (memo[mask] != -1)
            return memo[mask];

        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0)
                continue; // Used
            for (int j = i + 1; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0)
                    continue; // Used

                int currentScore = op * gcd(nums[i], nums[j]);
                int nextScore = backtrack(nums, mask | (1 << i) | (1 << j), op + 1, memo);
                maxVal = Math.max(maxVal, currentScore + nextScore);
            }
        }
        return memo[mask] = maxVal;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
