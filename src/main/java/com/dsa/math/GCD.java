package com.dsa.math;

/**
 * Greatest Common Divisor of Strings (LeetCode 1071)
 * 
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t
 * (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x
 * divides both str1 and str2.
 * 
 * Strategy: If str1 + str2 == str2 + str1, then a GCD exists. The length of the
 * GCD is gcd(len1, len2).
 */
public class GCD {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
