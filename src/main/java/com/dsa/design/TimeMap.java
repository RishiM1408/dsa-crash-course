package com.dsa.design;

import java.util.*;

/**
 * Time Based Key-Value Store (LeetCode 981)
 * 
 * Design a time-based key-value data structure that can store multiple values
 * for the same key at different time stamps
 * and retrieve the key's value at a certain timestamp.
 * 
 * Time: set O(1) or O(log n), get O(log n)
 */
public class TimeMap {

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Data> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<Data> list, int timestamp) {
        int low = 0;
        int high = list.size() - 1;
        String res = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int time = list.get(mid).timestamp;

            if (time == timestamp)
                return list.get(mid).value;

            if (time < timestamp) {
                res = list.get(mid).value; // Valid candidate (prev_time <= timestamp)
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
