package com.dsa.arrays;

import java.util.*;

/**
 * LeetCode 49: Group Anagrams
 * Given an array of strings strs, group the anagrams together.
 *
 * Pattern: HashMap Key Design
 * The key can be:
 * 1. Sorted string: "eat" -> "aet", "tea" -> "aet". O(K log K)
 * 2. Character count array as string/tuple: "eat" -> "1#0#0#0#1...". O(K)
 *
 * We will use the Character Count method for O(NK) time complexity.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            // Create a unique key from the character counts
            String key = String.valueOf(ca);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solver = new GroupAnagrams();

        // Test Case 1: ["eat","tea","tan","ate","nat","bat"]
        String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result1 = solver.groupAnagrams(strs1);
        System.out.println("Test Case 1 Output: " + result1);
        // Verify size should be 3 and groups correct
        if (result1.size() == 3) {
            System.out.println("Test Case 1: PASS (Size Check)");
        } else {
            System.out.println("Test Case 1: FAIL (Expected Size 3, Got " + result1.size() + ")");
        }

        // Test Case 2: [""]
        String[] strs2 = { "" };
        List<List<String>> result2 = solver.groupAnagrams(strs2);
        System.out
                .println("Test Case 2: " + (result2.size() == 1 && result2.get(0).get(0).equals("") ? "PASS" : "FAIL"));

        // Test Case 3: ["a"]
        String[] strs3 = { "a" };
        List<List<String>> result3 = solver.groupAnagrams(strs3);
        System.out.println(
                "Test Case 3: " + (result3.size() == 1 && result3.get(0).get(0).equals("a") ? "PASS" : "FAIL"));
    }
}
