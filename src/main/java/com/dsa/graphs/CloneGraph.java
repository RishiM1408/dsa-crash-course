package com.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 133: Clone Graph
 * Given a reference of a node in a connected undirected graph. Return a deep
 * copy (clone) of the graph.
 *
 * Pattern: DFS + HashMap
 * Map<Node, Node> to store visited/cloned nodes.
 */
public class CloneGraph {

    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {
        CloneGraph solver = new CloneGraph();

        // Test Case: Adj list [[2,4],[1,3],[2,4],[1,3]] (1 connects to 2,4; 2 connects
        // to 1,3...)
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node cloned = solver.cloneGraph(n1);

        boolean pass = (cloned != n1) && (cloned.val == 1) && (cloned.neighbors.size() == 2);
        // Deep checks could be more exhaustive

        System.out.println("Test Case 1: " + (pass ? "PASS" : "FAIL"));
    }
}
