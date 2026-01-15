package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76: Minimum Window Substring
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window.
 *
 * Pattern: Sliding Window (Dynamic Size)
 * 1. Expand 'right' pointer until window contains all characters of t.
 * 2. Contract 'left' pointer to minimize size while still valid.
 * 3. Update global minLen if current valid window is smaller.
 * 
 * Time: O(m + n), Space: O(1) (128 char ASCII)
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Character counts for t
        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        int required = t.length();
        // Or we can track number of unique characters required.
        // Let's stick to total characters required.
        // Actually, the simpler way is tracking "count of required chars remaining".

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length(); // Total characters to match

        char[] sChars = s.toCharArray();

        while (right < sChars.length) {
            char rChar = sChars[right];
            if (tMap[rChar] > 0) {
                count--;
            }
            tMap[rChar]--; // Decrement always. If it goes negative, it means we have extra of this char.
            right++;

            // While window is valid
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char lChar = sChars[left];
                tMap[lChar]++; // Put back into required map

                // If tMap[lChar] becomes positive, it means we needed this char and now we are
                // missing it.
                if (tMap[lChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();

        // Test Case 1: s = "ADOBECODEBANC", t = "ABC" -> "BANC"
        System.out.println("Test Case 1: " + (solver.minWindow("ADOBECODEBANC", "ABC").equals("BANC") ? "PASS"
                : "FAIL (Got " + solver.minWindow("ADOBECODEBANC", "ABC") + ")"));

        // Test Case 2: s = "a", t = "a" -> "a"
        System.out.println("Test Case 2: "
                + (solver.minWindow("a", "a").equals("a") ? "PASS" : "FAIL (Got " + solver.minWindow("a", "a") + ")"));

        // Test Case 3: s = "a", t = "aa" -> ""
        System.out.println("Test Case 3: "
                + (solver.minWindow("a", "aa").equals("") ? "PASS" : "FAIL (Got " + solver.minWindow("a", "aa") + ")"));

        // Test Case 4: s = "ab", t = "b" -> "b"
        System.out.println("Test Case 4: " + (solver.minWindow("ab", "b").equals("b") ? "PASS"
                : "FAIL (Got " + solver.minWindow("ab", "b") + ")"));
    }
}
