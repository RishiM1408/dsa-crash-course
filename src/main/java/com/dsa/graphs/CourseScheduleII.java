package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

/**
 * Topic: Graphs II (Topological Sort)
 * Problem: Course Schedule II
 * LeetCode: 210
 * Patter: Kahn's Algorithm (BFS)
 * Complexity: O(V + E) Time | O(V + E) Space
 */
public class CourseScheduleII {

    /**
     * Returns the ordering of courses to take to finish all courses.
     * 
     * Logic (Kahn's Algorithm):
     * 1. Build Adjacency List (Graph) and Indegree Array.
     * Indegree = number of prerequisites for a course.
     * 2. Add all nodes with Indegree == 0 to a Queue (Ready to take).
     * 3. Process Queue:
     * - Add current node to Result.
     * - For each neighbor, decrement Indegree.
     * - If neighbor's Indegree becomes 0, add to Queue.
     * 4. If result size != numCourses, there is a Cycle (Impossible).
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build Graph
        for (int[] pr : prerequisites) {
            int course = pr[0];
            int prereq = pr[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        // Add courses with no prereqs to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            result[index++] = current;

            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // Check for cycle
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }

    public static void main(String[] args) {
        CourseScheduleII solver = new CourseScheduleII();

        // 4 courses.
        // 1 depends on 0.
        // 2 depends on 0.
        // 3 depends on 1 and 2.
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        int[] order = solver.findOrder(numCourses, prerequisites);
        System.out.println("Course Order: " + Arrays.toString(order));
        // Expected: [0, 1, 2, 3] or [0, 2, 1, 3]
    }
}
