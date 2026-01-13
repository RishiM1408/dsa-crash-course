package com.dsa.tries;

/**
 * Topic: Tries (Prefix Trees)
 * Problem: Implement Trie
 * Complexity: O(m) Time per op | O(m * N * 26) Space
 */
public class Trie {

    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public void setEnd() {
            isEndOfWord = true;
        }

        public boolean isEnd() {
            return isEndOfWord;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // false
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println("Search 'app': " + trie.search("app")); // true
    }
}
