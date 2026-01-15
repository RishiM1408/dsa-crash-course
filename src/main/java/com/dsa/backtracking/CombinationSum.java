package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 39: Combination Sum
 *
 * Pattern: Backtracking (Unbounded Knapsack)
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();

        // Test Case 1: [2,3,6,7], target=7 -> [[2,2,3],[7]]
        List<List<Integer>> res = solver.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        System.out.println("Test Case 1: " + (res.size() == 2 ? "PASS" : "FAIL (Got " + res + ")"));
    }
}
