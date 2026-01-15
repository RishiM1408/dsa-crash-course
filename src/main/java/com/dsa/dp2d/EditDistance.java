package com.dsa.dp2d;

/**
 * LeetCode 72: Edit Distance
 *
 * Pattern: 2D DP
 * dp[i][j] min operations to convert word1[0..i-1] to word2[0..j-1]
 * If characters match: dp[i][j] = dp[i-1][j-1]
 * Else: 1 + min(insert, delete, replace)
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                            Math.min(dp[i - 1][j], // Delete
                                    dp[i][j - 1])); // Insert
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance solver = new EditDistance();

        // Test Case 1: "horse", "ros" -> 3
        System.out.println("Test Case 1: " + (solver.minDistance("horse", "ros") == 3 ? "PASS" : "FAIL"));

        // Test Case 2: "intention", "execution" -> 5
        System.out.println("Test Case 2: " + (solver.minDistance("intention", "execution") == 5 ? "PASS" : "FAIL"));
    }
}
