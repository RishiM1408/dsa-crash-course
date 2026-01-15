package com.dsa.dp;

/**
 * LeetCode 91: Decode Ways
 *
 * Pattern: DP
 * dp[i] = num ways to decode s[0..i]
 * If s[i] != '0', we can decode as single digit: dp[i] += dp[i-1]
 * If s[i-1..i] is between "10" and "26", we can decode as two digits: dp[i] +=
 * dp[i-2]
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solver = new DecodeWays();

        // Test Case 1: "12" -> 2 ("AB", "L")
        System.out.println("Test Case 1: "
                + (solver.numDecodings("12") == 2 ? "PASS" : "FAIL (Got " + solver.numDecodings("12") + ")"));

        // Test Case 2: "226" -> 3 ("BZ", "VF", "BBF")
        System.out.println("Test Case 2: "
                + (solver.numDecodings("226") == 3 ? "PASS" : "FAIL (Got " + solver.numDecodings("226") + ")"));

        // Test Case 3: "06" -> 0
        System.out.println("Test Case 3: "
                + (solver.numDecodings("06") == 0 ? "PASS" : "FAIL (Got " + solver.numDecodings("06") + ")"));
    }
}
