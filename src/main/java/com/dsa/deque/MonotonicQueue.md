# Monotonic Queue (Deque)

## 🧠 Theory High-Level

A **Deque** (Double-Ended Queue) allows insertion/deletion from both ends.
A **Monotonic Queue** maintains elements in a specific order (increasing or decreasing) by removing elements that violate the property when a new element is added.

## 🔑 SDE-2 Pattern: Decreasing Deque for Sliding Window Max

To find the maximum in a sliding window in **O(n)** time:

- We need the "Max" to always be available at the front (`peekFirst()`).
- When we slide the window:
  1.  **Remove Old**: If the element at the front is out of the window range, remove it.
  2.  **Maintain Order**: Before adding current element `x`, remove all elements from the back that are smaller than `x` (because `x` is newer and larger, so they can never be the max again).
  3.  **Add New**: Add `x` to the back.

## ⚔️ The Challenge: Sliding Window Maximum

**Problem**: Given array `nums` and window size `k`, return max sliding window.

### Logic

- Store **indices** in the Deque (to easily check window bounds).
- Correctness: The Deque front is always the index of the maximum element for the current window.
- Complexity: Each element is added once and removed once. O(n).

## 💻 Code Solution

See [SlidingWindowMaximum.java](SlidingWindowMaximum.java).
