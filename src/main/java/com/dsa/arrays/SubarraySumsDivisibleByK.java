package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 974: Subarray Sums Divisible by K
 * Given an integer array nums and an integer k, return the number of non-empty
 * subarrays that have a sum divisible by k.
 *
 * Pattern: Prefix Sum + HashMap (Remainder)
 * (Sum[j] - Sum[i]) % k == 0 => Sum[j] % k == Sum[i] % k
 * BEWARE: Java's % operator can return negative values. We need (sum % k + k) %
 * k to ensure positive remainders.
 */
public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix sum 0 has remainder 0, count 1

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            // Calculate remainder, handling negative numbers correctly
            int remainder = (currentSum % k + k) % k;

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK solver = new SubarraySumsDivisibleByK();

        // Test Case 1: [4,5,0,-2,-3,1], k = 5
        // Prefix sums: 4, 9, 9, 7, 4, 5
        // Rems (mod 5): 4, 4, 4, 2, 4, 0
        // Map: {0:1}
        // i=0, rem=4. Count+=0. Map{0:1, 4:1}
        // i=1, rem=4. Count+=1. Map{0:1, 4:2}
        // i=2, rem=4. Count+=2. Map{0:1, 4:3}
        // i=3, rem=2. Count+=0. Map{0:1, 4:3, 2:1}
        // i=4, rem=4. Count+=3. Map{0:1, 4:4, 2:1}
        // i=5, rem=0. Count+=1 (base case). Map{0:2, 4:4, 2:1}
        // Total count = 0+1+2+0+3+1 = 7.
        int[] nums1 = { 4, 5, 0, -2, -3, 1 };
        int k1 = 5;
        System.out.println("Test Case 1: " + (solver.subarraysDivByK(nums1, k1) == 7 ? "PASS"
                : "FAIL (Expected 7, Got " + solver.subarraysDivByK(nums1, k1) + ")"));

        // Test Case 2: [5], k = 9
        int[] nums2 = { 5 };
        int k2 = 9;
        System.out.println("Test Case 2: " + (solver.subarraysDivByK(nums2, k2) == 0 ? "PASS"
                : "FAIL (Expected 0, Got " + solver.subarraysDivByK(nums2, k2) + ")")); // 5 % 9 != 0

        // Test Case 3: Negative numbers only [-1, -9], k = 5
        // -1 % 5 = -1 => 4. Map{0:1, 4:1}
        // -10 % 5 = 0. Count+=1. Map{0:2, 4:1}
        // Total 1. Subarray [-9] sum -9? No. Subarray [-1, -9] sum -10. Divisible.
        // Wait, what about first one? -1 is not divisible.
        // Returns 1.
        int[] nums3 = { -1, -9 };
        int k3 = 5;
        System.out.println("Test Case 3: " + (solver.subarraysDivByK(nums3, k3) == 1 ? "PASS"
                : "FAIL (Expected 1, Got " + solver.subarraysDivByK(nums3, k3) + ")"));
    }
}
