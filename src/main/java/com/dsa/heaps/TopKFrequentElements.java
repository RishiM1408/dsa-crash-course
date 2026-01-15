package com.dsa.heaps;

import java.util.*;

/**
 * LeetCode 347: Top K Frequent Elements
 *
 * Pattern: HashMap + Min Heap (or Bucket Sort)
 * Use HashMap to count frequencies.
 * Use Min Heap to keep top k frequencies.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        // Min Heap sorted by frequency (ascending)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int n : map.keySet()) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll(); // remove element with smallest frequency
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solver = new TopKFrequentElements();

        // Test Case 1: [1,1,1,2,2,3], k=2 -> [1,2]
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        int[] res1 = solver.topKFrequent(nums1, 2);
        Arrays.sort(res1);
        System.out.println("Test Case 1: "
                + (Arrays.toString(res1).equals("[1, 2]") ? "PASS" : "FAIL (Got " + Arrays.toString(res1) + ")"));
    }
}
