package com.dsa.graphs;

/**
 * Find the Celebrity (LeetCode 277)
 * 
 * Suppose you are at a party with n people (labeled from 0 to n - 1), and one
 * of them represents the celebrity.
 * A celebrity is known by everyone else, but the celebrity knows no one.
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B.
 * 
 * Strategy: Logical Deduction (Two Pass).
 */
public class FindTheCelebrity {

    // Mock Relations for local compilation
    private boolean knows(int a, int b) {
        return true; // Placeholder
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}
