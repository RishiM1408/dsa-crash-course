package com.dsa.tries;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 648: Replace Words
 *
 * Pattern: Trie
 * For each word in sentence, find shortest prefix in dictionary.
 */
public class ReplaceWords {

    private TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.isEnd = true;
            node.word = word;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            if (i > 0)
                sb.append(" ");
            sb.append(findRoot(words[i]));
        }

        return sb.toString();
    }

    private String findRoot(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null || node.isEnd) {
                break;
            }
            node = node.children[idx];
        }
        // If we stopped at a node that isEnd, return that word (shortest prefix).
        // Logic fix: The loop breaks IF node.children is null OR node.isEnd.
        // If node.isEnd is true, we found a prefix.
        if (node != null && node.isEnd && node.word != null)
            return node.word;
        return word;
    }

    public static void main(String[] args) {
        ReplaceWords solver = new ReplaceWords();

        // Test Case 1: dict=["cat","bat","rat"], sentence="the cattle was rattled by
        // the battery"
        // -> "the cat was rat by the bat"
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        String res = solver.replaceWords(dict, sentence);

        System.out.println("Test Case 1: " + (res.equals(expected) ? "PASS" : "FAIL (Got '" + res + "')"));
    }
}
