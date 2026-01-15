package com.dsa.slidingwindow;

import java.util.Arrays;

/**
 * LeetCode 567: Permutation in String
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 *
 * Pattern: Sliding Window (Fixed Size)
 * We need to find if any substring of s2 of length s1.length() has the same
 * character counts as s1.
 * 
 * Approach:
 * 1. Count frequencies of chars in s1.
 * 2. Maintain a window of size s1.length() on s2.
 * 3. Compare window frequencies with s1 frequencies.
 * Time: O(n), Space: O(1) (26 chars)
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i])
                matches++;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26)
                return true;

            // Add right character
            int indexR = s2.charAt(r) - 'a';
            s2Count[indexR]++;
            if (s1Count[indexR] == s2Count[indexR]) {
                matches++;
            } else if (s1Count[indexR] + 1 == s2Count[indexR]) {
                matches--;
            }

            // Remove left character
            int indexL = s2.charAt(l) - 'a';
            s2Count[indexL]--;
            if (s1Count[indexL] == s2Count[indexL]) {
                matches++;
            } else if (s1Count[indexL] - 1 == s2Count[indexL]) {
                matches--;
            }
            l++;
        }

        return matches == 26;
    }

    // Alternative simpler implementation using Arrays.equals for O(26*n) which is
    // still O(n)
    public boolean checkInclusionSimple(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, windowCount))
            return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;
            windowCount[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Count, windowCount))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString solver = new PermutationInString();

        // Test Case 1: s1 = "ab", s2 = "eidbaooo" -> true ("ba" is permutation of "ab")
        System.out
                .println("Test Case 1: " + (solver.checkInclusion("ab", "eidbaooo") ? "PASS" : "FAIL (Expected true)"));

        // Test Case 2: s1 = "ab", s2 = "eidboaoo" -> false
        System.out.println(
                "Test Case 2: " + (!solver.checkInclusion("ab", "eidboaoo") ? "PASS" : "FAIL (Expected false)"));

        // Test Case 3: s1 = "adc", s2 = "dcda" -> true ("cda" matches "adc")
        System.out.println("Test Case 3: " + (solver.checkInclusion("adc", "dcda") ? "PASS" : "FAIL (Expected true)"));

        // Test Case 4: s1 = "hello", s2 = "ooolleoooleh" -> false
        System.out.println(
                "Test Case 4: " + (!solver.checkInclusion("hello", "ooolleoooleh") ? "PASS" : "FAIL (Expected false)"));

        // Simpler implementation checks
        System.out.println("Test Case 1 (Simple): "
                + (solver.checkInclusionSimple("ab", "eidbaooo") ? "PASS" : "FAIL (Expected true)"));
        System.out.println("Test Case 2 (Simple): "
                + (!solver.checkInclusionSimple("ab", "eidboaoo") ? "PASS" : "FAIL (Expected false)"));
    }
}
