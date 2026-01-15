package com.dsa.arrays;

/**
 * LeetCode 41: First Missing Positive
 * Given an unsorted integer array nums, return the smallest missing positive
 * integer.
 * You must implement an algorithm that runs in O(n) time and uses constant
 * extra space.
 *
 * Pattern: Cyclic Sort / Index as Hash Key
 * We want to put 1 at index 0, 2 at index 1, ..., k at index k-1.
 * Iterate through the array and swap numbers to their correct positions.
 * Then scan again to find the first index i where nums[i] != i + 1.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // While nums[i] is in the range [1, n] and is not at its correct position
            // AND the number at the target position is not already correct (to avoid
            // infinite loops with duplicates)
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive solver = new FirstMissingPositive();

        // Test Case 1: [1,2,0] -> 3
        int[] nums1 = { 1, 2, 0 };
        System.out.println("Test Case 1 ({1, 2, 0}): " + (solver.firstMissingPositive(nums1) == 3 ? "PASS"
                : "FAIL (Expected 3, Got " + solver.firstMissingPositive(nums1) + ")"));

        // Test Case 2: [3,4,-1,1] -> 2
        int[] nums2 = { 3, 4, -1, 1 };
        System.out.println("Test Case 2 ({3, 4, -1, 1}): " + (solver.firstMissingPositive(nums2) == 2 ? "PASS"
                : "FAIL (Expected 2, Got " + solver.firstMissingPositive(nums2) + ")"));

        // Test Case 3: [7,8,9,11,12] -> 1
        int[] nums3 = { 7, 8, 9, 11, 12 };
        System.out.println("Test Case 3 ({7, 8, 9, 11, 12}): " + (solver.firstMissingPositive(nums3) == 1 ? "PASS"
                : "FAIL (Expected 1, Got " + solver.firstMissingPositive(nums3) + ")"));

        // Test Case 4: [1] -> 2
        int[] nums4 = { 1 };
        System.out.println("Test Case 4 ({1}): " + (solver.firstMissingPositive(nums4) == 2 ? "PASS"
                : "FAIL (Expected 2, Got " + solver.firstMissingPositive(nums4) + ")"));
    }
}
