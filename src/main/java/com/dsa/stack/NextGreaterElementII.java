package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 503: Next Greater Element II
 * Given a circular integer array nums, return the next greater number for every
 * element in nums.
 *
 * Pattern: Monotonic Stack + Circular Array
 * Iterate 2*n times. Use index % n.
 * Stack stores indices.
 * Time: O(n), Space: O(n)
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII solver = new NextGreaterElementII();

        // Test Case 1: [1,2,1] -> [2,-1,2]
        int[] nums1 = { 1, 2, 1 };
        int[] res1 = solver.nextGreaterElements(nums1);
        System.out.println("Test Case 1: "
                + (Arrays.toString(res1).equals("[2, -1, 2]") ? "PASS" : "FAIL (Got " + Arrays.toString(res1) + ")"));

        // Test Case 2: [1,2,3,4,3] -> [2,3,4,-1,4]
        int[] nums2 = { 1, 2, 3, 4, 3 };
        int[] res2 = solver.nextGreaterElements(nums2);
        System.out.println("Test Case 2: " + (Arrays.toString(res2).equals("[2, 3, 4, -1, 4]") ? "PASS"
                : "FAIL (Got " + Arrays.toString(res2) + ")"));
    }
}
