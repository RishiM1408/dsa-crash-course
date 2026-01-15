package com.dsa.binarysearch;

/**
 * LeetCode 33: Search in Rotated Sorted Array
 *
 * Pattern: Binary Search
 * Determine which half is sorted. Check if target is in that sorted range.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solver = new SearchInRotatedSortedArray();

        // Test Case 1: [4,5,6,7,0,1,2], target=0 -> 4
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Test Case 1: " + (solver.search(nums1, 0) == 4 ? "PASS" : "FAIL"));

        // Test Case 2: [4,5,6,7,0,1,2], target=3 -> -1
        System.out.println("Test Case 2: " + (solver.search(nums1, 3) == -1 ? "PASS" : "FAIL"));
    }
}
