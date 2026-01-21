package com.dsa.arrays;

/**
 * Merge Sorted Array (LeetCode 88)
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, represents the number of elements in nums1
 * and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * Strategy: Fill from the back to avoid overwriting.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (index2 >= 0) {
            if (index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[mergeIndex--] = nums1[index1--];
            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }
    }
}
