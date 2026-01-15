package com.dsa.stack;

import java.util.Stack;

/**
 * LeetCode 150: Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Pattern: Stack
 * Push numbers. When operator (+, -, *, /) comes, pop two, apply op, push
 * result.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solver = new EvaluateReversePolishNotation();

        // Test Case 1: ["2","1","+","3","*"] -> ((2 + 1) * 3) = 9
        String[] t1 = { "2", "1", "+", "3", "*" };
        System.out.println(
                "Test Case 1: " + (solver.evalRPN(t1) == 9 ? "PASS" : "FAIL (Got " + solver.evalRPN(t1) + ")"));

        // Test Case 2: ["4","13","5","/","+"] -> (4 + (13 / 5)) = 6
        String[] t2 = { "4", "13", "5", "/", "+" };
        System.out.println(
                "Test Case 2: " + (solver.evalRPN(t2) == 6 ? "PASS" : "FAIL (Got " + solver.evalRPN(t2) + ")"));
    }
}
