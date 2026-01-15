package com.dsa.binarysearch;

import java.util.Arrays;

/**
 * LeetCode 1011: Capacity To Ship Packages Within D Days
 *
 * Pattern: Binary Search on Answer
 * Range: [Max(weights), Sum(weights)]
 * Check if capacity is feasible.
 */
public class CapacityToShipPackages {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int d = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                d++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return d <= days;
    }

    public static void main(String[] args) {
        CapacityToShipPackages solver = new CapacityToShipPackages();

        // Test Case 1: [1,2,3,4,5,6,7,8,9,10], days=5 -> 15
        int[] w1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Test Case 1: "
                + (solver.shipWithinDays(w1, 5) == 15 ? "PASS" : "FAIL (Got " + solver.shipWithinDays(w1, 5) + ")"));
    }
}
