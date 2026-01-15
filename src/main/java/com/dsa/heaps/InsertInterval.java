package com.dsa.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 57: Insert Interval
 *
 * Pattern: Iterate and Merge
 * 1. Add all intervals ending before newInterval starts.
 * 2. Merge all overlapping intervals with newInterval.
 * 3. Add all remaining intervals.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlap
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3. Add remaining
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval solver = new InsertInterval();

        // Test Case 1: [[1,3],[6,9]], new=[2,5] -> [[1,5],[6,9]]
        int[][] in1 = { { 1, 3 }, { 6, 9 } };
        int[] new1 = { 2, 5 };
        int[][] res1 = solver.insert(in1, new1);
        System.out.println("Test Case 1: " + (Arrays.deepToString(res1).equals("[[1, 5], [6, 9]]") ? "PASS"
                : "FAIL (Got " + Arrays.deepToString(res1) + ")"));
    }
}
