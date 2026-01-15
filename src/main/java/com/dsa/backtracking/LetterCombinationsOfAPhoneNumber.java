package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 17: Letter Combinations of a Phone Number
 *
 * Pattern: Backtracking
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final String[] MAPPING = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        backtrack(result, "", digits, 0);
        return result;
    }

    private void backtrack(List<String> result, String current, String digits, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = MAPPING[digit];
        for (char c : letters.toCharArray()) {
            backtrack(result, current + c, digits, index + 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solver = new LetterCombinationsOfAPhoneNumber();

        // Test Case 1: "23" -> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        List<String> res = solver.letterCombinations("23");
        System.out.println("Test Case 1: " + (res.size() == 9 && res.contains("ad") ? "PASS" : "FAIL"));
    }
}
