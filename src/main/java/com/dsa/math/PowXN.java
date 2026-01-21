package com.dsa.math;

/**
 * Pow(x, n) (LeetCode 50)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 * 
 * Strategy: Binary Exponentiation (Iterative or Recursive).
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class PowXN {

    public double myPow(double x, int n) {
        long N = n; // Use long to prevent overflow when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if ((N % 2) == 1) {
                result = result * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
            N /= 2;
        }
        return result;
    }
}
