package com.dsa.bitmanipulation;

import java.util.Arrays;

/**
 * LeetCode 338: Counting Bits
 *
 * Pattern: DP + Bit Manipulation
 * dp[i] = dp[i >> 1] + (i & 1)
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits solver = new CountingBits();

        // Test Case 1: n=2 -> [0,1,1]
        int[] res1 = solver.countBits(2);
        System.out.println("Test Case 1: " + (Arrays.toString(res1).equals("[0, 1, 1]") ? "PASS" : "FAIL"));

        // Test Case 2: n=5 -> [0,1,1,2,1,2]
        int[] res2 = solver.countBits(5);
        System.out.println("Test Case 2: " + (Arrays.toString(res2).equals("[0, 1, 1, 2, 1, 2]") ? "PASS" : "FAIL"));
    }
}
