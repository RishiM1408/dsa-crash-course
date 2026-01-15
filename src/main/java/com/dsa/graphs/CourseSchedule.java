package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 207: Course Schedule
 *
 * Pattern: Topological Sort (Kahn's Algorithm)
 * 1. Build adjacency list and indegree array.
 * 2. Add all nodes with 0 indegree to queue.
 * 3. Process queue. Count processed nodes.
 * 4. If count == numCourses, typical DAG (true).
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] relation : prerequisites) {
            int course = relation[0];
            int prereq = relation[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solver = new CourseSchedule();

        // Test Case 1: 2, [[1,0]] -> true
        int[][] p1 = { { 1, 0 } };
        System.out.println("Test Case 1: " + (solver.canFinish(2, p1) ? "PASS" : "FAIL"));

        // Test Case 2: 2, [[1,0],[0,1]] -> false
        int[][] p2 = { { 1, 0 }, { 0, 1 } };
        System.out.println("Test Case 2: " + (!solver.canFinish(2, p2) ? "PASS" : "FAIL"));
    }
}
