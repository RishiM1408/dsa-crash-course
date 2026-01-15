package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 131: Palindrome Partitioning
 *
 * Pattern: Backtracking
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(result, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();

        // Test Case 1: "aab" -> [["a","a","b"], ["aa","b"]]
        List<List<String>> res = solver.partition("aab");
        System.out.println("Test Case 1: " + (res.size() == 2 ? "PASS" : "FAIL"));
    }
}
