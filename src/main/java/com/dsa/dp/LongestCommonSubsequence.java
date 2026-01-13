package com.dsa.dp;

/**
 * Topic: 2D Dynamic Programming
 * Problem: Longest Common Subsequence
 * Complexity: O(m*n) Time | O(m*n) Space
 */
public class LongestCommonSubsequence {

    /**
     * Finds the length of the longest common subsequence between two strings.
     * 
     * Logic:
     * dp[i][j] represents LCS of text1[0..i-1] and text2[0..j-1].
     * If chars match: dp[i][j] = 1 + dp[i-1][j-1]
     * If chars don't match: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solver = new LongestCommonSubsequence();

        System.out.println("LCS: " + solver.longestCommonSubsequence("abcde", "ace"));
        // Expected: 3 ("ace")
    }
}
