package com.dsa.systemdesign;

import java.util.*;

/**
 * LeetCode 380: Insert Delete GetRandom O(1)
 *
 * Pattern: ArrayList + HashMap
 * Map stores val -> index in ArrayList.
 * Remove: Swap element with last element in list, remove last. Update map.
 */
public class InsertDeleteGetRandomO1 {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int index = map.get(val);
        int lastVal = list.get(list.size() - 1);

        // Swap
        list.set(index, lastVal);
        map.put(lastVal, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 set = new InsertDeleteGetRandomO1();

        System.out.println("Insert 1: " + set.insert(1));
        System.out.println("Remove 2: " + !set.remove(2));
        System.out.println("Insert 2: " + set.insert(2));
        System.out.println("GetRandom: " + set.getRandom()); // 1 or 2
        System.out.println("Remove 1: " + set.remove(1));
        System.out.println("Insert 2: " + !set.insert(2));
        System.out.println("GetRandom: " + (set.getRandom() == 2 ? "PASS" : "FAIL"));
    }
}
