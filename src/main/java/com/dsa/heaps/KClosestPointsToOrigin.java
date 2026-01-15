package com.dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode 973: K Closest Points to Origin
 *
 * Pattern: Max Heap
 * Maintain a heap of size K. If heap full and current point is closer than
 * heap.peek(), poll and add current.
 * Comparator: descending distance.
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        // Max Heap maintains closest K points. We want to remove the FARTHEST among
        // them if we find a closer one.
        // So actually we need Max Heap of distances? Yes. The root will be the largest
        // distance in the top K.
        // If we find something smaller, we evict the largest.

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solver = new KClosestPointsToOrigin();

        // Test Case 1: [[1,3],[-2,2]], k=1 -> [[-2,2]]
        // Distances: sqrt(10), sqrt(8). Closest is [-2,2].
        int[][] points1 = { { 1, 3 }, { -2, 2 } };
        int[][] res1 = solver.kClosest(points1, 1);
        System.out.println("Test Case 1: " + (res1.length == 1 && res1[0][0] == -2 && res1[0][1] == 2 ? "PASS"
                : "FAIL(Got " + Arrays.deepToString(res1) + ")"));
    }
}
