package com.dsa.stack;

import java.util.Stack;

/**
 * LeetCode 84: Largest Rectangle in Histogram
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 *
 * Pattern: Monotonic Increasing Stack
 * We need to find the first smaller element to the left and to the right for
 * each bar.
 * When we pop from stack, the current element (i) is the right boundary
 * (exclusive),
 * and the new top of stack is the left boundary (exclusive).
 * Area = height[popped] * (right - left - 1)
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use 0 height at the end to pop everything remaining in stack
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solver = new LargestRectangleInHistogram();

        // Test Case 1: [2,1,5,6,2,3] -> 10
        int[] h1 = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Test Case 1: " + (solver.largestRectangleArea(h1) == 10 ? "PASS"
                : "FAIL (Got " + solver.largestRectangleArea(h1) + ")"));

        // Test Case 2: [2,4] -> 4
        int[] h2 = { 2, 4 };
        System.out.println("Test Case 2: " + (solver.largestRectangleArea(h2) == 4 ? "PASS"
                : "FAIL (Got " + solver.largestRectangleArea(h2) + ")"));

        // Test Case 3: [2,1,2] -> 3
        int[] h3 = { 2, 1, 2 };
        System.out.println("Test Case 3: " + (solver.largestRectangleArea(h3) == 3 ? "PASS"
                : "FAIL (Got " + solver.largestRectangleArea(h3) + ")"));
    }
}
