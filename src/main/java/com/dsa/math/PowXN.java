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
        long exponent = n; // Use long to prevent overflow when n = Integer.MIN_VALUE
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;
        double currentProduct = x;

        while (exponent > 0) {
            if ((exponent % 2) == 1) {
                result = result * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
            exponent /= 2;
        }
        return result;
    }
}
