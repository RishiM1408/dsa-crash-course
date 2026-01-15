package com.dsa.systemdesign;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LeetCode 460: LFU Cache
 *
 * Pattern: Two HashMaps + Doubly Linked List (or LinkedHashSet)
 * 1. vals: key -> value
 * 2. counts: key -> frequency
 * 3. lists: frequency -> Set of keys (LinkedHashSet maintains insertion order
 * for LRU within same frequency)
 * 4. min: minimum frequency
 */
public class LFUCache {

    private int cap;
    private int min;
    private Map<Integer, Integer> vals;
    private Map<Integer, Integer> counts;
    private Map<Integer, LinkedHashSet<Integer>> lists;

    public LFUCache(int capacity) {
        cap = capacity;
        min = -1;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;

        int count = counts.get(key);
        counts.put(key, count + 1);

        lists.get(count).remove(key);

        // If min frequency list is empty, increment min
        if (count == min && lists.get(count).isEmpty()) {
            min++;
        }

        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);

        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0)
            return;

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key); // Update frequency
            return;
        }

        if (vals.size() >= cap) {
            int evict = lists.get(min).iterator().next();
            lists.get(min).remove(evict);
            vals.remove(evict);
            counts.remove(evict);
        }

        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println("Get 1: " + (lfu.get(1) == 1 ? "PASS" : "FAIL")); // freq(1)=2
        lfu.put(3, 3); // evicts 2 (freq 1, LRU)
        System.out.println("Get 2: " + (lfu.get(2) == -1 ? "PASS" : "FAIL"));
        System.out.println("Get 3: " + (lfu.get(3) == 3 ? "PASS" : "FAIL")); // freq(3)=2
        lfu.put(4, 4); // evicts 1 (freq 2, LRU than 3? Wait. 1 has freq 2. 3 has freq 2. 1 was
                       // accessed first... wait. 1 accessed at step 3. 3 accessed at step 5. 1 was
                       // accessed LONGER AGO? No, 1 accessed recently. 3 accessed recently.
        // Let's trace.
        // put(1,1), put(2,2). [1:1, 2:1], min=1.
        // get(1) -> returns 1. freq(1)=2. min=1. List(1)={2}. List(2)={1}.
        // put(3,3). cap reached. min=1. evict from List(1) -> 2. [1:2, 3:1]. min=1.
        // List(1)={3}. List(2)={1}.
        // get(2) -> -1. Correct.
        // get(3) -> 3. freq(3)=2. min=1. List(1)={}. min->2. List(2)={1, 3}.
        // put(4,4). cap reached. min=2. evict from List(2). Iterator order?
        // LinkedHashSet preserves insertion order. 1 added first? 1 was added to
        // List(2) at step 3. 3 added to List(2) at step 5. So 1 is older in List(2).
        // Evict 1.
        // [3:2, 4:1].
        // get(1) -> -1.
        // get(3) -> 3.
        // get(4) -> 4.

        System.out.println("Get 1: " + (lfu.get(1) == -1 ? "PASS" : "FAIL"));
        System.out.println("Get 3: " + (lfu.get(3) == 3 ? "PASS" : "FAIL"));
        System.out.println("Get 4: " + (lfu.get(4) == 4 ? "PASS" : "FAIL"));
    }
}
