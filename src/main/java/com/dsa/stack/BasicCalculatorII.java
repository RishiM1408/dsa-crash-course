package com.dsa.stack;

import java.util.*;

/**
 * Basic Calculator II (LeetCode 227)
 * 
 * Given a string s which represents an expression, evaluate this expression and
 * return its value.
 * The integer division should truncate toward zero.
 * 
 * Operations: +, -, *, /
 * Strategy: Stack. Process * and / immediately, push results. Sum up stack for
 * + and -.
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char operation = '+';
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    if (currentNumber == 0)
                        stack.push(0); // Handle division by zero
                    else
                        stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }
        return result;
    }
}
