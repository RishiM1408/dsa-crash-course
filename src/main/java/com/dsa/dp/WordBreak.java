package com.dsa.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * LeetCode 139: Word Break
 *
 * Pattern: DP 1D
 * dp[i] = true if s.substring(0, i) can be segmented.
 * dp[i] = dp[j] && wordDict.contains(s.substring(j, i)) for any 0 <= j < i
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak solver = new WordBreak();

        // Test Case 1: s = "leetcode", wordDict = ["leet", "code"] -> true
        System.out.println(
                "Test Case 1: " + (solver.wordBreak("leetcode", Arrays.asList("leet", "code")) ? "PASS" : "FAIL"));

        // Test Case 2: s = "applepenapple", wordDict = ["apple", "pen"] -> true
        System.out.println(
                "Test Case 2: " + (solver.wordBreak("applepenapple", Arrays.asList("apple", "pen")) ? "PASS" : "FAIL"));

        // Test Case 3: s = "catsandog", wordDict = ["cats", "dog", "sand", "and",
        // "cat"] -> false
        System.out.println("Test Case 3: "
                + (!solver.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")) ? "PASS"
                        : "FAIL"));
    }
}
