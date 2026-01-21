package com.dsa.design;

import java.util.*;

/**
 * Max Stack (LeetCode 716)
 * 
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * 
 * Strategy: Double Linked List + TreeMap.
 * DLL for O(1) Push/Pop/Top
 * TreeMap<Value, List<Node>> for O(log n) PeekMax/PopMax
 */
public class MaxStack {

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    class DLL {
        Node head;
        Node tail;

        public DLL() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev.next = x;
            tail.prev = x;
            return x;
        }

        public int pop() {
            return unlink(tail.prev).val;
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    private DLL dll;
    private TreeMap<Integer, List<Node>> map;

    public MaxStack() {
        dll = new DLL();
        map = new TreeMap<>();
    }

    public void push(int x) {
        Node node = dll.add(x);
        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.isEmpty())
            map.remove(val);
        return val;
    }

    public int top() {
        return dll.peek();
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);
        if (list.isEmpty())
            map.remove(max);
        dll.unlink(node);
        return max;
    }
}
