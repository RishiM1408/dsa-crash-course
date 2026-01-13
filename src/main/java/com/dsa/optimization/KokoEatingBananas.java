package com.dsa.optimization;

/**
 * Topic: Advanced Optimization
 * Problem: Koko Eating Bananas
 * Pattern: Binary Search on Answer Space
 * Complexity: O(n * log(maxPile)) Time | O(1) Space
 */
public class KokoEatingBananas {

    /**
     * Finds the minimum eating speed 'k' such that Koko can eat all bananas within
     * 'h' hours.
     * 
     * Logic:
     * The possible speeds range from 1 to Max(piles).
     * This range is monotonic:
     * - If speed 's' works, then 's+1' definitely works.
     * - If speed 's' fails, then 's-1' definitely fails.
     * 
     * We Binary Search for the *smallest* 's' that works.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile); // Max pile size
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid; // Try smaller speed
            } else {
                left = mid + 1; // Need more speed
            }
        }

        return left;
    }

    // Predicate Function
    private boolean canEatAll(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles) {
            // Equivalent to Math.ceil(pile / speed)
            hours += (pile + speed - 1) / speed;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas solver = new KokoEatingBananas();

        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println("Min Speed: " + solver.minEatingSpeed(piles, h));
        // Expected: 4 (Hours: 1 + 2 + 2 + 3 = 8)
    }
}
