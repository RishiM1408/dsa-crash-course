package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Topic: Backtracking
 * Problem: Permutations
 * LeetCode: 46
 * Pattern: Choose, Explore, Unchoose
 * Complexity: O(n * n!) Time | O(n) Space
 */
public class Permutations {

    /**
     * Generates all possible permutations of an array of distinct integers.
     * 
     * Logic:
     * We build the permutations one element at a time.
     * 1. Iterate through available numbers.
     * 2. Choose a number (if not already used).
     * 3. Explore (Recursive call).
     * 4. Unchoose (Backtrack: remove number to try next option).
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // Base Case: If tempList contains all numbers, we found a valid permutation.
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i]))
                continue; // Skip if already chosen

            // Choose
            tempList.add(nums[i]);

            // Explore
            backtrack(result, tempList, nums);

            // Unchoose
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();

        int[] nums = { 1, 2, 3 };
        System.out.println("Permutations: " + solver.permute(nums));
        // Expected: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
    }
}
