package com.dsa.tries;

public class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;
    public String word; // Optional: store word at valid end for easy retrieval

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
        word = null;
    }
}
