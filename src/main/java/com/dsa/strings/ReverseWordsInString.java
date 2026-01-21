package com.dsa.strings;

/**
 * Reverse Words in a String (LeetCode 151)
 * 
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Strategy: Trim, split by whitespace, and join in reverse.
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        // Split by one or more spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
