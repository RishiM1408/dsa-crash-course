package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic: Two Pointers & Sliding Window
 * Problem: Longest Repeating Character Replacement
 * Complexity: O(n) Time | O(1) Space (since only 26 uppercase chars)
 */
public class LongestRepeatingCharacterReplacement {

    /**
     * Finds the length of the longest substring containing the same letter
     * after replacing at most k characters.
     * 
     * Logic:
     * Window condition: (windowLen - countOfMostFreqChar) <= k
     * If valid, we try to expand window (maxLength = max(maxLength, windowLen)).
     * If invalid, we shrink the window from the left until it becomes valid again.
     */
    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add current char to window
            charCounts[s.charAt(right) - 'A']++;

            // Update the frequency of the most frequent char in current window
            // Note: We don't need to decrement maxFreq when shrinking because
            // we are only interested in finding a *longer* valid window.
            maxFreq = Math.max(maxFreq, charCounts[s.charAt(right) - 'A']);

            // Window Size = (right - left + 1)
            // Number of replacements needed = Window Size - maxFreq
            // If replacements needed > k, window is invalid. Shrink it.
            if ((right - left + 1) - maxFreq > k) {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();

        System.out.println(solver.characterReplacement("ABAB", 2)); // 4
        System.out.println(solver.characterReplacement("AABABBA", 1)); // 4
    }
}
