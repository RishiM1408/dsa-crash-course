package com.dsa.matrix;

/**
 * Search a 2D Matrix (LeetCode 74)
 * 
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * Strategy: Treat the 2D matrix as a sorted 1D array and perform binary search.
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target)
                return true;
            else if (midVal < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
