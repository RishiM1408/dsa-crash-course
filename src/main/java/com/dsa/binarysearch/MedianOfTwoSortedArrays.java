package com.dsa.binarysearch;

/**
 * LeetCode 4: Median of Two Sorted Arrays
 *
 * Pattern: Binary Search on Partition
 * Partition both arrays (x and y) such that left half has (x+y+1)/2 elements.
 * Ensure maxLeftX <= minRightY and maxLeftY <= minRightX.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found partition
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();

        // Test Case 1: [1,3], [2] -> 2.0
        int[] n1 = { 1, 3 };
        int[] n2 = { 2 };
        System.out.println("Test Case 1: " + (solver.findMedianSortedArrays(n1, n2) == 2.0 ? "PASS" : "FAIL"));

        // Test Case 2: [1,2], [3,4] -> 2.5
        int[] n3 = { 1, 2 };
        int[] n4 = { 3, 4 };
        System.out.println("Test Case 2: " + (solver.findMedianSortedArrays(n3, n4) == 2.5 ? "PASS" : "FAIL"));
    }
}
