package com.dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Topic: Heaps & Intervals
 * Problem: Task Scheduler
 * Complexity: O(n) Time | O(1) Space
 */
public class TaskScheduler {

    /**
     * Calculates the least number of units of time to finish all tasks.
     * 
     * Logic:
     * We need to schedule the most frequent tasks first to minimize idle time.
     * Max Frequency = f_max
     * Number of tasks with this max frequency = n_max
     * 
     * Formula:
     * Min Intervals = (f_max - 1) * (n + 1) + n_max
     * 
     * However, the answer cannot be less than the total number of tasks.
     * So, Result = Max(tasks.length, calculated_intervals)
     */
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char t : tasks) {
            frequencies[t - 'A']++;
        }

        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int maxIdleTime = (maxFreq - 1) * n;

        for (int i = 24; i >= 0; i--) {
            // Cannot subtract more than the "gaps" created by maxFreq task
            // Math.min handles the edge case where another task has same freq as maxFreq
            maxIdleTime -= Math.min(maxFreq - 1, frequencies[i]);
        }

        // If maxIdleTime is negative, it means we have plenty of tasks to fill gaps, so
        // no idle time needed.
        maxIdleTime = Math.max(0, maxIdleTime);

        return tasks.length + maxIdleTime;
    }

    public static void main(String[] args) {
        TaskScheduler solver = new TaskScheduler();

        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println("Least Interval: " + solver.leastInterval(tasks, n));
        // Expected: 8 (A -> B -> idle -> A -> B -> idle -> A -> B)
    }
}
