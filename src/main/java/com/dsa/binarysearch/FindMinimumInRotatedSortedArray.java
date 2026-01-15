package com.dsa.binarysearch;

/**
 * LeetCode 153: Find Minimum in Rotated Sorted Array
 *
 * Pattern: Binary Search (Modified)
 * Compare mid with high. If mid > high, pivot is in right half (low = mid + 1).
 * Else pivot in left half (high = mid).
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solver = new FindMinimumInRotatedSortedArray();

        // Test Case 1: [3,4,5,1,2] -> 1
        int[] nums1 = { 3, 4, 5, 1, 2 };
        System.out.println("Test Case 1: " + (solver.findMin(nums1) == 1 ? "PASS" : "FAIL"));

        // Test Case 2: [4,5,6,7,0,1,2] -> 0
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Test Case 2: " + (solver.findMin(nums2) == 0 ? "PASS" : "FAIL"));
    }
}
