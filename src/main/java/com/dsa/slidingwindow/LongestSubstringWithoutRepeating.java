package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 * Pattern: Sliding Window (Variable Size)
 * Use a Set or Map to store characters in the current window.
 * If we encounter a character already in the window, shrink the window from the
 * left until the character is removed.
 *
 * Time: O(n), Space: O(min(m, n)) where n is string length and m is charset
 * size.
 */
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // Map stores character -> index where it last appeared
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                // If we have seen the character, move left pointer to after the previous
                // occurrence
                // BUT only if the previous occurrence is within the current window (index >=
                // left)
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right); // Update last seen index
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solver = new LongestSubstringWithoutRepeating();

        // Test Case 1: "abcabcbb" -> 3 ("abc")
        System.out.println("Test Case 1: " + (solver.lengthOfLongestSubstring("abcabcbb") == 3 ? "PASS"
                : "FAIL (Got " + solver.lengthOfLongestSubstring("abcabcbb") + ")"));

        // Test Case 2: "bbbbb" -> 1 ("b")
        System.out.println("Test Case 2: " + (solver.lengthOfLongestSubstring("bbbbb") == 1 ? "PASS"
                : "FAIL (Got " + solver.lengthOfLongestSubstring("bbbbb") + ")"));

        // Test Case 3: "pwwkew" -> 3 ("wke")
        System.out.println("Test Case 3: " + (solver.lengthOfLongestSubstring("pwwkew") == 3 ? "PASS"
                : "FAIL (Got " + solver.lengthOfLongestSubstring("pwwkew") + ")"));

        // Test Case 4: "" -> 0
        System.out.println("Test Case 4: " + (solver.lengthOfLongestSubstring("") == 0 ? "PASS"
                : "FAIL (Got " + solver.lengthOfLongestSubstring("") + ")"));

        // Test Case 5: "abba" -> 2 ("ab" or "ba") - testing the 'left' pointer max
        // check
        System.out.println("Test Case 5: " + (solver.lengthOfLongestSubstring("abba") == 2 ? "PASS"
                : "FAIL (Got " + solver.lengthOfLongestSubstring("abba") + ")"));
    }
}
