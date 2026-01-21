# Linked List

## 🧠 Theory High-Level

Linked Lists consist of nodes where each node points to the next. They allow **O(1) insertion/deletion** if the reference is known, but **O(n) access** time.
Interview questions rarely ask for basic insertion. They ask for **reordering**, **cycle detection**, or **merging**.

## 🔑 Key Interview Pattern: Fast & Slow Pointers

Also known as the **Tortoise and Hare** algorithm.

- **Concept**: Use two pointers. `Slow` moves 1 step. `Fast` moves 2 steps.
- **Applications**:
  1.  **Find Middle**: When `Fast` reaches end, `Slow` is at the middle.
  2.  **Detect Cycle**: If `Fast` collides with `Slow`, there is a cycle.
  3.  **Remove N-th Node from End**: Move Fast `N` steps ahead, then move both.

## ⚔️ The Challenge: Reorder List

**Problem**: Given `L0 -> L1 -> ... -> Ln-1 -> Ln`, reorder to `L0 -> Ln -> L1 -> Ln-1 ...`

### Logic

This complex operation is actually 3 simple sub-problems combined:

1.  **Find Middle**: Split the list into two halves using Fast/Slow pointers.
2.  **Reverse Second Half**: Reverse the direction of the second list (`Ln -> Ln-1 ...`).
3.  **Merge**: Zip the two lists together (Take one from First, one from Second, repeat).

## 💻 Code Solution

See [ReorderList.java](ReorderList.java) for the implementation.
