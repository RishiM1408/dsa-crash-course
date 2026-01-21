package com.dsa.recursion;

import java.util.List;

/**
 * Nested List Weight Sum (LeetCode 339)
 * 
 * You are given a nested list of integers nestedList. Each element is either an
 * integer or a list whose elements may also be integers or other lists.
 * The depth of an integer is the number of lists that it is inside of. For
 * example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to
 * its depth.
 * Return the sum of each integer in nestedList multiplied by its depth.
 */
public class NestedListWeightSum {

    // Mock Interface for NestedInteger
    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += helper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}
