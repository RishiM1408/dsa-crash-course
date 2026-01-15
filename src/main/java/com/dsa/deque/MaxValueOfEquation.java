package com.dsa.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 1499: Max Value of Equation
 * Evaluate y_i + y_j + |x_i - x_j| where |x_i - x_j| <= k.
 * Since x restricted to increasing, |x_i - x_j| = x_j - x_i.
 * Maximize y_i + y_j + x_j - x_i = (y_i - x_i) + (y_j + x_j).
 * For a fixed j, maximize (y_i - x_i) using Monotonic Decreasing Queue on
 * (y-x).
 */
public class MaxValueOfEquation {

    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new ArrayDeque<>(); // stores pair {y-x, x}
        int maxVal = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Remove outdated points (x - x_prev > k)
            while (!deque.isEmpty() && x - deque.peekFirst()[1] > k) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                maxVal = Math.max(maxVal, deque.peekFirst()[0] + y + x);
            }

            // Add current point, maintain decreasing order of (y-x)
            while (!deque.isEmpty() && deque.peekLast()[0] <= y - x) {
                deque.pollLast();
            }
            deque.offerLast(new int[] { y - x, x });
        }

        return maxVal;
    }

    public static void main(String[] args) {
        MaxValueOfEquation solver = new MaxValueOfEquation();

        // Test Case 1: [[1,3],[2,0],[5,10],[6,-10]], k=1 -> 4
        int[][] p1 = { { 1, 3 }, { 2, 0 }, { 5, 10 }, { 6, -10 } };
        System.out.println("Test Case 1: " + (solver.findMaxValueOfEquation(p1, 1) == 4 ? "PASS" : "FAIL"));

        // Test Case 2: [[0,0],[3,0],[9,2]], k=3 -> 3
        int[][] p2 = { { 0, 0 }, { 3, 0 }, { 9, 2 } };
        System.out.println("Test Case 2: " + (solver.findMaxValueOfEquation(p2, 3) == 3 ? "PASS" : "FAIL"));
    }
}
