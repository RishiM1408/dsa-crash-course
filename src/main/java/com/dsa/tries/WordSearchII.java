package com.dsa.tries;

import java.util.*;

/**
 * Word Search II (LeetCode 212)
 * 
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * 
 * Strategy: Backtracking + Trie.
 */
public class WordSearchII {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words)
            addWord(w);

        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, root, res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        char letter = board[r][c];
        TrieNode curr = node.children.get(letter);

        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null; // Avoid duplicates
        }

        board[r][c] = '#'; // Mark visited
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#'
                    && curr.children.containsKey(board[nr][nc])) {
                dfs(board, nr, nc, curr, res);
            }
        }

        board[r][c] = letter; // Backtrack

        // Optimisation: Prune leaf nodes
        if (curr.children.isEmpty()) {
            node.children.remove(letter);
        }
    }

    private void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = word;
    }
}
