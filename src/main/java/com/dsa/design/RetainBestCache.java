package com.dsa.design;

import java.util.*;

/**
 * Retain Best Cache
 * 
 * Design a cache that has a capacity. Each item has a key, value, and a rank.
 * When the cache is full and a new item is inserted, discard the item with the
 * lowest rank.
 * If there are multiple items with the lowest rank, discard the one that was
 * least recently used (LRU).
 * 
 * Strategy: Map<Key, Node> for access. TreeMap<Rank, Set<Node>> or
 * TreeMap<Rank, LinkedHashSet<Node>> for Rank/LRU.
 */
public class RetainBestCache {

    class Node {
        int key;
        int val;
        int rank;

        public Node(int k, int v, int r) {
            key = k;
            val = v;
            rank = r;
        }
    }

    private int capacity;
    private Map<Integer, Node> map; // Key -> Node
    private TreeMap<Integer, Set<Integer>> rankMap; // Rank -> Set of Keys (LinkedHashSet implies insertion order for
                                                    // LRU within rank?)
    // Actually, for LRU within same rank, we need LinkedHashSet.

    public RetainBestCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.rankMap = new TreeMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        // Update LRU by re-inserting into LinkedHashSet
        rankMap.get(node.rank).remove(key);
        rankMap.get(node.rank).add(key);

        return node.val;
    }

    public void put(int key, int val, int rank) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;

            // Rank changed? Unlikely in standard definition, but if so:
            if (node.rank != rank) {
                rankMap.get(node.rank).remove(key);
                if (rankMap.get(node.rank).isEmpty())
                    rankMap.remove(node.rank);
                node.rank = rank;
                rankMap.computeIfAbsent(rank, k -> new LinkedHashSet<>()).add(key);
            } else {
                // Access
                rankMap.get(rank).remove(key);
                rankMap.get(rank).add(key);
            }
            return;
        }

        if (map.size() >= capacity) {
            evict();
        }

        Node newNode = new Node(key, val, rank);
        map.put(key, newNode);
        rankMap.computeIfAbsent(rank, k -> new LinkedHashSet<>()).add(key);
    }

    private void evict() {
        if (rankMap.isEmpty())
            return;

        Integer minRank = rankMap.firstKey();
        Set<Integer> keys = rankMap.get(minRank);

        // Evict LRU from this rank (first in LinkedHashSet)
        Iterator<Integer> it = keys.iterator();
        if (it.hasNext()) {
            int keyToEvict = it.next();
            it.remove();
            if (keys.isEmpty())
                rankMap.remove(minRank);
            map.remove(keyToEvict);
        }
    }
}
