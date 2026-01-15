package com.dsa.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56: Merge Intervals
 *
 * Pattern: Sorting
 * Sort by start time. Iterate and merge overlapping intervals.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Overlap
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solver = new MergeIntervals();

        // Test Case 1: [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
        int[][] in1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res1 = solver.merge(in1);
        System.out.println("Test Case 1: " + (Arrays.deepToString(res1).equals("[[1, 6], [8, 10], [15, 18]]") ? "PASS"
                : "FAIL (Got " + Arrays.deepToString(res1) + ")"));
    }
}
