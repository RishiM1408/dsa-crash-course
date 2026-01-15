package com.dsa.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 300: Longest Increasing Subsequence
 *
 * Pattern: Binary Search (Patience Sorting) - O(N log N)
 * Maintain list of tails. If x > last tail, append. Else replace first tail >=
 * x.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            if (tails.isEmpty() || num > tails.get(tails.size() - 1)) {
                tails.add(num);
            } else {
                // Find first element >= num and replace it
                int i = 0, j = tails.size() - 1;
                while (i < j) {
                    int mid = (i + j) / 2;
                    if (tails.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                tails.set(i, num);
            }
        }

        return tails.size();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();

        // Test Case 1: [10,9,2,5,3,7,101,18] -> 4 ([2,3,7,18])
        int[] nums1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("Test Case 1: "
                + (solver.lengthOfLIS(nums1) == 4 ? "PASS" : "FAIL (Got " + solver.lengthOfLIS(nums1) + ")"));

        // Test Case 2: [0,1,0,3,2,3] -> 4 ([0,1,2,3])
        int[] nums2 = { 0, 1, 0, 3, 2, 3 };
        System.out.println("Test Case 2: "
                + (solver.lengthOfLIS(nums2) == 4 ? "PASS" : "FAIL (Got " + solver.lengthOfLIS(nums2) + ")"));
    }
}
