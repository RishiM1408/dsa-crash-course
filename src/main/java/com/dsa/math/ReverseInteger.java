package com.dsa.math;

/**
 * Reverse Integer (LeetCode 7)
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Strategy: Modulo 10 to extract digits, build result checking for overflow.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before updating result
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            result = result * 10 + digit;
        }
        return result;
    }
}
