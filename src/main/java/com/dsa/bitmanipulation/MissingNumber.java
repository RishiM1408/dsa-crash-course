package com.dsa.bitmanipulation;

/**
 * LeetCode 268: Missing Number
 *
 * Pattern: Bit Manipulation (XOR)
 * XOR all numbers in range [0, n] and all numbers in array.
 * a ^ a = 0. Result is missing number.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        MissingNumber solver = new MissingNumber();

        // Test Case 1: [3,0,1] -> 2
        System.out.println("Test Case 1: " + (solver.missingNumber(new int[] { 3, 0, 1 }) == 2 ? "PASS" : "FAIL"));

        // Test Case 2: [0,1] -> 2
        System.out.println("Test Case 2: " + (solver.missingNumber(new int[] { 0, 1 }) == 2 ? "PASS" : "FAIL"));
    }
}
