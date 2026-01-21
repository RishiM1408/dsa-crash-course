package com.dsa.heaps;

import java.util.*;

/**
 * Employee Free Time (LeetCode 759)
 * 
 * We are given a list schedule of employees, which represents the working time
 * for each employee.
 * Each employee has a list of non-overlapping Intervals, and these intervals
 * are in sorted order.
 * Return the list of finite intervals representing common, positive-length free
 * time for all employees, also in sorted order.
 * 
 * Strategy: Merge Intervals or Min-Heap.
 */
public class EmployeeFreeTime {

    class Interval {
        private int start;
        private int end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();
        for (List<Interval> list : schedule) {
            all.addAll(list);
        }

        Collections.sort(all, (a, b) -> a.getStart() - b.getStart());

        List<Interval> res = new ArrayList<>();
        int end = all.get(0).getEnd();

        for (int i = 1; i < all.size(); i++) {
            Interval curr = all.get(i);
            if (curr.getStart() > end) {
                res.add(new Interval(end, curr.getStart()));
                end = curr.getEnd();
            } else {
                end = Math.max(end, curr.getEnd());
            }
        }
        return res;
    }
}
