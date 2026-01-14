package com.dsa.bits;

/**
 * Topic: Bit Manipulation
 * Problem: Single Number
 * LeetCode: 136
 * Pattern: XOR Properties
 * Complexity: O(n) Time | O(1) Space
 */
public class SingleNumber {

    /**
     * Finds the single number in an array where every other number appears twice.
     * 
     * Logic:
     * XOR Properties:
     * 1. A ^ 0 = A
     * 2. A ^ A = 0
     * 3. A ^ B ^ A = (A ^ A) ^ B = 0 ^ B = B
     * 
     * If we XOR all numbers, the duplicates differ out to 0, leaving only the
     * single number.
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber solver = new SingleNumber();

        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println("Single Number: " + solver.singleNumber(nums));
        // Expected: 4
    }
}
