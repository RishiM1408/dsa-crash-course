package com.dsa.bitmanipulation;

/**
 * LeetCode 191: Number of 1 Bits
 *
 * Pattern: Bit Manipulation
 * n & (n - 1) clears the lowest set bit. Repeat until n becomes 0.
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits solver = new NumberOf1Bits();

        // Test Case 1: 11 (1011) -> 3
        System.out.println("Test Case 1: " + (solver.hammingWeight(11) == 3 ? "PASS" : "FAIL"));

        // Test Case 2: 128 (10000000) -> 1
        System.out.println("Test Case 2: " + (solver.hammingWeight(128) == 1 ? "PASS" : "FAIL"));
    }
}
