package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 78: Subsets
 *
 * Pattern: Backtracking
 * Pick or Don't Pick strategy.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();

        // Test Case 1: [1,2,3] -> 8 subsets
        List<List<Integer>> res = solver.subsets(new int[] { 1, 2, 3 });
        System.out.println("Test Case 1: " + (res.size() == 8 ? "PASS" : "FAIL (Got " + res.size() + ")"));
    }
}
