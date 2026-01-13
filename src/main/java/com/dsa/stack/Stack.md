# Stack & Queue

## 🧠 Theory High-Level

**Stacks** are LIFO (Last-In, First-Out). **Queues** are FIFO (First-In, First-Out).
While basic usage (DFS/BFS) is standard, SDE-2 interviews focus on **Monotonic Stacks**.

## 🔑 SDE-2 Pattern: Monotonic Stack

Used to find the **Next Greater Element** (or Next Smaller) for every element in an array in **O(n)** time.

- **Concept**: Maintain a stack that is always sorted (increasing or decreasing).
- **Action**: When a new element comes in that breaks the order, pop from the stack. The new element is the "Next Greater" for the popped element.

## ⚔️ The Challenge: Daily Temperatures

**Problem**: Given an array of temps `temperatures`, return an array such that `answer[i]` is the number of days you have to wait after the `i-th` day to get a warmer temperature.

### Naive Approach (O(n²))

For each day, look ahead until you find a warmer day.

### Optimal Approach (O(n) - Monotonic Stack)

We want to find the **Next Greater Element** for each day.

1.  Iterate through `temperatures`.
2.  While `CurrentTemp > Stack.TopTemp`:
    - This means `CurrentTemp` is the warmer day `Stack.Top` was waiting for!
    - Pop index from stack.
    - `Answer[PoppedIndex] = CurrentIndex - PoppedIndex`.
3.  Push `CurrentIndex` to stack.

## 💻 Code Solution

See [DailyTemperatures.java](DailyTemperatures.java) for the implementation.
