package com.dsa.tries;

/**
 * LeetCode 208: Implement Trie (Prefix Tree)
 *
 * Pattern: Trie
 */
public class ImplementTrie {

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + (trie.search("apple") ? "PASS" : "FAIL"));
        System.out.println("Search 'app': " + (!trie.search("app") ? "PASS" : "FAIL"));
        System.out.println("StartsWith 'app': " + (trie.startsWith("app") ? "PASS" : "FAIL"));
        trie.insert("app");
        System.out.println("Search 'app': " + (trie.search("app") ? "PASS" : "FAIL"));
    }
}
