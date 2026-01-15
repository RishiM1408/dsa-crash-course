package com.dsa.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 212: Word Search II
 *
 * Pattern: Backtracking (DFS) + Trie
 * Build Trie of words. Iterate grid. DFS to find words in Trie.
 * Optimization: Prune Trie branches after finding words.
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        // Build Trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.isEnd = true;
            node.word = w;
        }

        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char letter = board[r][c];
        TrieNode curr = parent.children[letter - 'a'];

        if (curr.isEnd) {
            result.add(curr.word);
            curr.isEnd = false; // Avoid duplicates
            // Optimization: could prune leaves here
        }

        board[r][c] = '#'; // Mark visited

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#'
                    && curr.children[board[nr][nc] - 'a'] != null) {
                dfs(board, nr, nc, curr, result);
            }
        }

        board[r][c] = letter; // Backtrack
    }

    public static void main(String[] args) {
        WordSearchII solver = new WordSearchII();

        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };
        List<String> res = solver.findWords(board, words);
        // Expect ["eat", "oath"] order varies
        System.out.println("Test Case 1: "
                + (res.contains("eat") && res.contains("oath") && res.size() == 2 ? "PASS" : "FAIL (Got " + res + ")"));
    }
}
