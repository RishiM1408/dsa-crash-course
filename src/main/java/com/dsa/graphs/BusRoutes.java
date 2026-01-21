package com.dsa.graphs;

import java.util.*;

/**
 * Bus Routes (LeetCode 815)
 * 
 * BFS on Routes (not stops).
 * You are given an array routes representing bus routes where routes[i] is a
 * bus route that the ith bus repeats forever.
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        // Map: Stop -> List of Bus Routes passing through it
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedRoutes = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();

        q.offer(source);
        visitedStops.add(source);
        int buses = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            buses++;

            for (int i = 0; i < size; i++) {
                int currentStop = q.poll();

                List<Integer> busesAtStop = stopToRoutes.getOrDefault(currentStop, new ArrayList<>());
                for (int busId : busesAtStop) {
                    if (visitedRoutes[busId])
                        continue;
                    visitedRoutes[busId] = true;

                    for (int nextStop : routes[busId]) {
                        if (nextStop == target)
                            return buses;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
