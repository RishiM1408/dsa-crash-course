package com.dsa.design;

import java.util.*;

/**
 * Insert Delete GetRandom O(1) (LeetCode 380)
 * 
 * Implement the RandomizedSet class:
 * - insert(val): Inserts an item val into the set if not present. Returns true
 * if the item was not present, false otherwise.
 * - remove(val): Removes an item val from the set if present. Returns true if
 * the item was present, false otherwise.
 * - getRandom(): Returns a random element from the current set of elements.
 * 
 * Strategy: HashMap + ArrayList.
 * Map stores Val -> Index in ArrayList.
 * ArrayList stores the values to allow O(1) random access.
 * To remove in O(1), swap the element to remove with the last element of the
 * list, update map, and remove the last element.
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
        int lastElement = list.get(list.size() - 1);

        // Swap with last element
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove last
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
