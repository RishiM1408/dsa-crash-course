package com.dsa.strings;

import java.util.*;

/**
 * Palindrome Pairs (LeetCode 336)
 * 
 * Given a list of unique words, return all the pairs of the distinct indices
 * (i, j) in the given list,
 * so that the concatenation of the two words words[i] + words[j] is a
 * palindrome.
 * 
 * Strategy: HashMap for O(1) loop or Trie. Using HashMap approach.
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int n = w.length();

            // Case 1: Empty string interaction
            if (w.equals("")) {
                for (int j = 0; j < words.length; j++) {
                    if (j != i && isPalindrome(words[j])) {
                        res.add(Arrays.asList(i, j));
                        res.add(Arrays.asList(j, i));
                    }
                }
                continue;
            }

            // Case 2: Reverse exists
            String rev = new StringBuilder(w).reverse().toString();
            if (map.containsKey(rev) && map.get(rev) != i) {
                res.add(Arrays.asList(i, map.get(rev)));
            }

            // Case 3: Split word -> s1 + s2.
            // If s1 is palindrome, find reverse(s2). If found -> {rev(s2), w} is pal.
            // If s2 is palindrome, find reverse(s1). If found -> {w, rev(s1)} is pal.

            for (int k = 1; k < n; k++) {
                String s1 = w.substring(0, k);
                String s2 = w.substring(k);

                if (isPalindrome(s1)) {
                    String revS2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(revS2)) {
                        res.add(Arrays.asList(map.get(revS2), i));
                    }
                }

                if (isPalindrome(s2)) {
                    String revS1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(revS1)) {
                        res.add(Arrays.asList(i, map.get(revS1)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
