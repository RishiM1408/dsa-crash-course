package com.dsa.arrays;

import java.util.Arrays;

/**
 * LeetCode 238: Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 *
 * Pattern: Prefix Product + Suffix Product
 * 1. Pass 1: Calculate prefix products. answer[i] = product of
 * nums[0]...nums[i-1]
 * 2. Pass 2: Calculate suffix products on the fly and multiply with answer[i].
 * Time: O(n), Space: O(1) (excluding output array)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: Prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Pass 2: Suffix products (multiply on the fly)
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();

        // Test Case 1: [1,2,3,4] -> [24,12,8,6]
        int[] nums1 = { 1, 2, 3, 4 };
        int[] expected1 = { 24, 12, 8, 6 };
        int[] result1 = solver.productExceptSelf(nums1);
        System.out.println("Test Case 1: " + (Arrays.equals(result1, expected1) ? "PASS"
                : "FAIL (Expected " + Arrays.toString(expected1) + ", Got " + Arrays.toString(result1) + ")"));

        // Test Case 2: [-1,1,0,-3,3] -> [0,0,9,0,0]
        int[] nums2 = { -1, 1, 0, -3, 3 };
        int[] expected2 = { 0, 0, 9, 0, 0 };
        int[] result2 = solver.productExceptSelf(nums2);
        System.out.println("Test Case 2: " + (Arrays.equals(result2, expected2) ? "PASS"
                : "FAIL (Expected " + Arrays.toString(expected2) + ", Got " + Arrays.toString(result2) + ")"));
    }
}
