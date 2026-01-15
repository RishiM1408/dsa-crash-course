package com.dsa.dp2d;

/**
 * LeetCode 10: Regular Expression Matching
 *
 * Pattern: 2D DP
 * '.' matches any single char.
 * '*' matches zero or more of element preceding '*'.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Initialize for patterns like a*, a*b*, etc. that can match empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char preceding = p.charAt(j - 2);
                    if (preceding != '.' && preceding != sc) {
                        dp[i][j] = dp[i][j - 2]; // Zero occurrences
                    } else {
                        // Zero occurrences OR One/More occurrences (propagate from dp[i-1][j])
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching solver = new RegularExpressionMatching();

        // Test Case 1: "aa", "a" -> false
        System.out.println("Test Case 1: " + (!solver.isMatch("aa", "a") ? "PASS" : "FAIL"));

        // Test Case 2: "aa", "a*" -> true
        System.out.println("Test Case 2: " + (solver.isMatch("aa", "a*") ? "PASS" : "FAIL"));

        // Test Case 3: "ab", ".*" -> true
        System.out.println("Test Case 3: " + (solver.isMatch("ab", ".*") ? "PASS" : "FAIL"));
    }
}
