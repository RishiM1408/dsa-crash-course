package com.dsa.heaps;

import java.util.*;

/**
 * Reorganize String (LeetCode 767)
 * 
 * Given a string s, rearrange the characters of s so that any two adjacent
 * characters are not the same.
 * Return any possible rearrangement of s or return "" if not possible.
 * 
 * Strategy: Max Heap (Greedy). Always pick most frequent char, then pick next
 * most frequent to separate.
 */
public class ReorganizeString {

    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray())
            counts[c - 'a']++;

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts[b - 'a'] - counts[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > (s.length() + 1) / 2)
                return "";
            if (counts[i] > 0)
                maxHeap.offer((char) (i + 'a'));
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char a = maxHeap.poll();
            char b = maxHeap.poll();

            sb.append(a);
            sb.append(b);

            counts[a - 'a']--;
            counts[b - 'a']--;

            if (counts[a - 'a'] > 0)
                maxHeap.offer(a);
            if (counts[b - 'a'] > 0)
                maxHeap.offer(b);
        }

        if (!maxHeap.isEmpty())
            sb.append(maxHeap.poll());

        return sb.toString();
    }
}
