package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Topic: Stack (Monotonic Stack)
 * Problem: Daily Temperatures
 * LeetCode: 739
 * Complexity: O(n) Time | O(n) Space
 */
public class DailyTemperatures {

    /**
     * Finds how many days you have to wait to get a warmer temperature.
     * Uses a Monotonic Decreasing Stack.
     * 
     * Logic:
     * We iterate through the array. We want to find the NEXT greater element.
     * We keep indices in a stack.
     * If currentTemp > stack.topTemp, it means we found a warmer day for the day at
     * stack.top!
     * We pop the stack and calculate the difference in indices (current -
     * stack.pop()).
     * We repeat this until the stack is empty or currentTemp <= stack.topTemp.
     * Then we push the current index.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDayIndex = stack.pop();
                answer[prevDayIndex] = i - prevDayIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solver = new DailyTemperatures();

        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = solver.dailyTemperatures(temps);
        System.out.println(Arrays.toString(result));
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
