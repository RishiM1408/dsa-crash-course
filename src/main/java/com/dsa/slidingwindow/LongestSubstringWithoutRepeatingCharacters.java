package com.dsa.slidingwindow;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters (LeetCode 3)
 * 
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Strategy: Sliding Window with HashSet or HashMap.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
