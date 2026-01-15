package com.dsa.systemdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic: System Design DSA
 * Problem: LRU Cache
 * LeetCode: 146
 * Pattern: HashMap + Doubly Linked List
 * Complexity: O(1) Get and Put
 */
public class LRUCache {

    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    // Dummy Head (Most Recently Used) and Tail (Least Recently Used)
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize Dummy Nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insertAtHead(node); // Mark as Most Recently Used
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            node.value = value; // Update value
            insertAtHead(node);
        } else {
            if (cache.size() == capacity) {
                // Remove LRU (node before dummy tail)
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAtHead(newNode);
            cache.put(key, newNode);
        }
    }

    // Check this: Head <-> N1 <-> N2 <-> Tail
    // Head.next is MRU. Tail.prev is LRU.
    // Wait, typical LRU: new item at front (Head). Evict from back (Tail).
    // Let's stick to: Head -> MRU ... LRU -> Tail.
    // So "InsertAtHead" and "Remove(Tail.prev)".

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println("Get 1: " + lru.get(1)); // 1 (1 is now MRU)
        lru.put(3, 3); // Evicts 2
        System.out.println("Get 2: " + lru.get(2)); // -1 (Not found)
        lru.put(4, 4); // Evicts 1
        System.out.println("Get 1: " + lru.get(1)); // -1 (Not found)
        System.out.println("Get 3: " + lru.get(3)); // 3
        System.out.println("Get 4: " + lru.get(4)); // 4
    }
}
