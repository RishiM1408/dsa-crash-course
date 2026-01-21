package com.dsa.graphs;

import java.util.*;

/**
 * Network Delay Time (LeetCode 743)
 * 
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] =
 * (ui, vi, wi).
 * We send a signal from a given node k. Return the minimum time it takes for
 * all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * 
 * Strategy: Dijkstra's Algorithm.
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] t : times) {
            adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new int[] { t[1], t[2] });
        }

        // Min-Heap: [time, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if (dist.containsKey(node))
                continue;
            dist.put(node, d);

            if (dist.size() == n)
                return d; // All nodes reached

            if (adj.containsKey(node)) {
                for (int[] edge : adj.get(node)) {
                    int neighbor = edge[0];
                    int weight = edge[1];
                    if (!dist.containsKey(neighbor)) {
                        pq.offer(new int[] { d + weight, neighbor });
                    }
                }
            }
        }

        return dist.size() == n ? -1 : -1; // Should check if all reached. If loop finished and size != n, return -1.
        // Wait, logic correction: We return max distance if all reached. Here we return
        // as soon as size == n because Dijkstra processes in order.
        // If queue empty and size < n, impossible.
    }

    /* Correct logic for return at end */
    public int networkDelayTimeCorrect(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] t : times) {
            adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new int[] { t[1], t[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });

        Map<Integer, Integer> dist = new HashMap<>();
        int maxTime = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if (dist.containsKey(node))
                continue;
            dist.put(node, d);
            maxTime = Math.max(maxTime, d);

            if (adj.containsKey(node)) {
                for (int[] edge : adj.get(node)) {
                    int neighbor = edge[0];
                    int weight = edge[1];
                    if (!dist.containsKey(neighbor)) {
                        pq.offer(new int[] { d + weight, neighbor });
                    }
                }
            }
        }

        return dist.size() == n ? maxTime : -1;
    }
}
