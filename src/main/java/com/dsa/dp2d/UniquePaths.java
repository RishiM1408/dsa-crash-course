package com.dsa.dp2d;

import java.util.Arrays;

/**
 * LeetCode 62: Unique Paths
 *
 * Pattern: 2D DP
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solver = new UniquePaths();

        // Test Case 1: m=3, n=7 -> 28
        System.out.println("Test Case 1: " + (solver.uniquePaths(3, 7) == 28 ? "PASS" : "FAIL"));

        // Test Case 2: m=3, n=2 -> 3
        System.out.println("Test Case 2: " + (solver.uniquePaths(3, 2) == 3 ? "PASS" : "FAIL"));
    }
}
