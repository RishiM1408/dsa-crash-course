package com.dsa.stack;

import java.util.Stack;
import java.util.Arrays;

/**
 * LeetCode 739: Daily Temperatures
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature.
 *
 * Pattern: Monotonic Decreasing Stack (Indices)
 * Store indices in stack. If current temp > temp[stack.peek()], pop and
 * calculate distance.
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevTempIndex = stack.pop();
                result[prevTempIndex] = i - prevTempIndex;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solver = new DailyTemperatures();

        // Test Case 1: [73,74,75,71,69,72,76,73] -> [1,1,4,2,1,1,0,0]
        int[] t1 = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] expected1 = { 1, 1, 4, 2, 1, 1, 0, 0 };
        int[] res1 = solver.dailyTemperatures(t1);
        System.out.println("Test Case 1: "
                + (Arrays.equals(res1, expected1) ? "PASS" : "FAIL (Got " + Arrays.toString(res1) + ")"));

        // Test Case 2: [30,40,50,60] -> [1,1,1,0]
        int[] t2 = { 30, 40, 50, 60 };
        int[] expected2 = { 1, 1, 1, 0 };
        int[] res2 = solver.dailyTemperatures(t2);
        System.out.println("Test Case 2: "
                + (Arrays.equals(res2, expected2) ? "PASS" : "FAIL (Got " + Arrays.toString(res2) + ")"));
    }
}
