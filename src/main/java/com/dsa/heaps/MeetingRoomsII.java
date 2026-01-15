package com.dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode 253: Meeting Rooms II
 * Given an array of meeting time intervals, return the minimum number of
 * conference rooms required.
 *
 * Pattern: Min Heap
 * Sort by start time. Use Min Heap to track end times of meetings currently in
 * progress.
 * If earliest ending meeting ends before current meeting starts, reuse room
 * (poll).
 * Always add current meeting to heap.
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap keeps track of end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If the room with earliest end time is free, reuse it
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            // Add new end time (either new room or reused room with new end time)
            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII solver = new MeetingRoomsII();

        // Test Case 1: [[0,30],[5,10],[15,20]] -> 2
        int[][] in1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("Test Case 1: "
                + (solver.minMeetingRooms(in1) == 2 ? "PASS" : "FAIL (Got " + solver.minMeetingRooms(in1) + ")"));

        // Test Case 2: [[7,10],[2,4]] -> 1
        int[][] in2 = { { 7, 10 }, { 2, 4 } };
        System.out.println("Test Case 2: "
                + (solver.minMeetingRooms(in2) == 1 ? "PASS" : "FAIL (Got " + solver.minMeetingRooms(in2) + ")"));
    }
}
