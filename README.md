# 🎓 DSA Crash Course (SDE-2)

Welcome to the **High-Intensity DSA Crash Course**. This repository is designed to teach you the most critical SDE-2 interview patterns in a compressed format.

**Role**: Senior Staff Engineer at FAANG.
**Goal**: Master the 8 pillars of DSA efficiently.

---

## 📚 Curriculum & Topic Modules

Each module comes with a dedicated guide explaining the **Theory**, **SDE-2 Pattern**, **Challenge**, and **Solution**.

### 1. [Arrays & Hashing](src/main/java/com/dsa/arrays/ArraysAndHashing.md)

- **Focus**: Prefix Sums, Difference Arrays, HashMaps.
- **Pattern**: Transforming O(n²) range queries into O(1).
- **Challenge**: `Subarray Sum Equals K`.

### 2. [Two Pointers & Sliding Window](src/main/java/com/dsa/slidingwindow/SlidingWindow.md)

- **Focus**: Dynamic Window Sizing.
- **Pattern**: Expand (`right`) -> Check -> Shrink (`left`).
- **Challenge**: `Longest Repeating Character Replacement`.

### 3. [Stack & Queue](src/main/java/com/dsa/stack/Stack.md)

- **Focus**: Monotonic Stacks.
- **Pattern**: Finding "Next Greater Element" in O(n).
- **Challenge**: `Daily Temperatures`.

### 4. [Linked List](src/main/java/com/dsa/linkedlist/LinkedList.md)

- **Focus**: Fast & Slow Pointers (Tortoise & Hare).
- **Pattern**: Cycle Detection, Middle Finding, List Reversal.
- **Challenge**: `Reorder List`.

### 5. [Trees & Tries](src/main/java/com/dsa/trees/Trees.md)

- **Focus**: DFS/BFS Variants, BST Properties.
- **Pattern**: Using `Left < Root < Right` to prune search space.
- **Challenge**: `Lowest Common Ancestor of BST`.

### 6. [Heaps & Intervals](src/main/java/com/dsa/heaps/Heaps.md)

- **Focus**: Priority Queues, Greedy.
- **Pattern**: Processing most urgent tasks first (Max-Heap).
- **Challenge**: `Task Scheduler`.

### 7. [Graphs](src/main/java/com/dsa/graphs/Graphs.md)

- **Focus**: Disjoint Sets, Connectivity.
- **Pattern**: Union-Find for "Connected Components".
- **Challenge**: `Number of Provinces`.

### 8. [Dynamic Programming](src/main/java/com/dsa/dp/DynamicProgramming.md)

- **Focus**: Optimization, 1D DP.
- **Pattern**: Subproblems + Memoization.
- **Challenge**: `Coin Change`.

---

## 🚀 How to Run Code

All solutions are self-contained Java files with `main` methods.

```bash
# Example: Running the Arrays Module
javac src/main/java/com/dsa/arrays/SubarraySum.java
java -cp src/main/java com.dsa.arrays.SubarraySum
```

Checking out this repo gives you a complete toolkit for your SDE-2 loops. **Good luck.**
