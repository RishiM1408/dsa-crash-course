package com.dsa.tries;

/**
 * LeetCode 211: Design Add and Search Words Data Structure
 *
 * Pattern: Trie + DFS
 * '.' matches any character. Recursively search children.
 */
public class DesignAddAndSearchWords {

    private TrieNode root;

    public DesignAddAndSearchWords() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            if (node.children[idx] == null)
                return false;
            return search(word, index + 1, node.children[idx]);
        }
    }

    public static void main(String[] args) {
        DesignAddAndSearchWords dict = new DesignAddAndSearchWords();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        System.out.println("Search 'pad': " + (!dict.search("pad") ? "PASS" : "FAIL"));
        System.out.println("Search 'bad': " + (dict.search("bad") ? "PASS" : "FAIL"));
        System.out.println("Search '.ad': " + (dict.search(".ad") ? "PASS" : "FAIL"));
        System.out.println("Search 'b..': " + (dict.search("b..") ? "PASS" : "FAIL"));
    }
}
