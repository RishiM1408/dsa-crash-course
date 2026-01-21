package com.dsa.math;

import java.util.Arrays;

/**
 * Count Primes (LeetCode 204)
 * 
 * Given an integer n, return the number of prime numbers that are strictly less
 * than n.
 * 
 * Strategy: Sieve of Eratosthenes.
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as non-prime
                // Start from i*i because smaller multiples would have been marked by smaller
                // factors
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }
}
