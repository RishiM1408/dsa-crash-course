# Tries (Prefix Trees)

## 🧠 Theory High-Level

A **Trie** is a tree-like data structure used to efficiently store and retrieve keys in a dataset of strings.
It outperforms HashMaps for tasks like **Auto-Complete** or **Spell Checking** because it groups common prefixes.

## 🔑 SDE-2 Pattern: TrieNode Structure

- **Structure**: Each Node contains an array `children[26]` (for lowercase English) and a boolean `isEndOfWord`.
- **Traversal**: Moving from Node to `node.children[char - 'a']` is basically consuming one character of the string.

## ⚔️ The Challenge: Implement Trie

**Problem**: Implement a Trie with `insert`, `search`, and `startsWith`.

### Logic

1.  **Insert**: Iterate char by char. If child doesn't exist, create it. At end, mark `isEnd = true`.
2.  **Search**: Iterate char by char. If child null, return False. At end, return `isEnd`.
3.  **StartsWith**: Same as Search, but return True if you can consume the whole prefix (doesn't care about `isEnd`).

## 💻 Code Solution

See [Trie.java](Trie.java).
