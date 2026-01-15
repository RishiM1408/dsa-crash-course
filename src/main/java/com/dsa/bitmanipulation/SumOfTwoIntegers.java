package com.dsa.bitmanipulation;

/**
 * LeetCode 371: Sum of Two Integers
 *
 * Pattern: Bit Manipulation
 * Sum without carry: a ^ b
 * Carry: (a & b) << 1
 * Repeat until carry is 0.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solver = new SumOfTwoIntegers();

        // Test Case 1: 1 + 2 = 3
        System.out.println("Test Case 1: " + (solver.getSum(1, 2) == 3 ? "PASS" : "FAIL"));

        // Test Case 2: -2 + 3 = 1
        System.out.println("Test Case 2: " + (solver.getSum(-2, 3) == 1 ? "PASS" : "FAIL"));
    }
}
