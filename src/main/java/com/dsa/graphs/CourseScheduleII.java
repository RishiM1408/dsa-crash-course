package com.dsa.graphs;

import java.util.*;

/**
 * LeetCode 210: Course Schedule II
 *
 * Pattern: Kahn's Algorithm
 * Same as Course Schedule I but return the order.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result[index++] = curr;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }

        return index == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII solver = new CourseScheduleII();

        // Test Case 1: 2, [[1,0]] -> [0,1]
        int[][] p1 = { { 1, 0 } };
        int[] res1 = solver.findOrder(2, p1);
        System.out.println("Test Case 1: " + (Arrays.toString(res1).equals("[0, 1]") ? "PASS" : "FAIL"));

        // Test Case 2: 4, [[1,0],[2,0],[3,1],[3,2]] -> [0,1,2,3] or [0,2,1,3]
        int[][] p2 = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] res2 = solver.findOrder(4, p2);
        // Valid output starts with 0 and ends with 3. 1 and 2 in between.
        System.out.println("Test Case 2: " + (res2.length == 4 && res2[0] == 0 && res2[3] == 3 ? "PASS"
                : "FAIL (Got " + Arrays.toString(res2) + ")"));
    }
}
