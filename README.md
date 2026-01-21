# DSA Crash Course (SDE-2)

Welcome to the **High-Intensity DSA Crash Course**. This repository is designed to teach you the most critical SDE-2 interview patterns in a compressed format.

**Goal**: Master the 16 pillars of DSA efficiently.

---

<div align="center">
  <h3>🔥 COMPANY-WISE QUESTION BANK 🔥</h3>
  <p>Target your preparation for Amazon, Google, Rippling, Sprinklr, etc.</p>
  <a href="COMPANY_WISE_QUESTIONS.md"><b>👉 CLICK HERE TO ACCESS THE GUIDE 👈</b></a>
</div>

---

## Curriculum & Topic Modules

Each module comes with a dedicated guide.

### 1. [Arrays & Hashing](src/main/java/com/dsa/arrays/ArraysAndHashing.md)

- **Focus**: Prefix Sums, HashMaps.
- **Challenge**: `Subarray Sum Equals K`.

#### Practice Drills

- [Medium] **Contiguous Array** (LeetCode 525) - _Binary Array variation_
- [Medium] **Subarray Sums Divisible by K** (LeetCode 974) - _Modulo arithmetic_
- [Medium] **Product of Array Except Self** (LeetCode 238) - _Prefix + Suffix_
- [Medium] **Group Anagrams** (LeetCode 49) - _HashMap Key Design_
- [Hard] **First Missing Positive** (LeetCode 41) - _Index as Hash Key_

### 2. [Two Pointers & Sliding Window](src/main/java/com/dsa/slidingwindow/SlidingWindow.md)

- **Focus**: Dynamic Window Sizing.
- **Challenge**: `Longest Repeating Character Replacement`.

#### Practice Drills

- [Medium] **Permutation in String** (LeetCode 567) - _Fixed Window_
- [Hard] **Minimum Window Substring** (LeetCode 76) - _Dynamic Window Shrink_
- [Medium] **Longest Substring Without Repeating Characters** (LeetCode 3) - _Set/Map Tracking_
- [Medium] **Max Consecutive Ones III** (LeetCode 1004) - _Flipping 0s constraint_

### 3. [Stack & Queue](src/main/java/com/dsa/stack/Stack.md)

- **Focus**: Monotonic Stacks.
- **Challenge**: `Daily Temperatures`.

#### Practice Drills

- [Medium] **Next Greater Element II** (LeetCode 503) - _Circular Array_
- [Hard] **Largest Rectangle in Histogram** (LeetCode 84) - _Area Calculation_
- [Medium] **Evaluate Reverse Polish Notation** (LeetCode 150) - _Standard Stack_
- [Medium] **Min Stack** (LeetCode 155) - _Auxiliary Stack Design_
- [Medium] **Daily Temperatures** (LeetCode 739) - _Wait days calculation_

### 4. [Linked List](src/main/java/com/dsa/linkedlist/LinkedList.md)

- **Focus**: Fast & Slow Pointers.
- **Challenge**: `Reorder List`.

#### Practice Drills

- [Medium] **Palindrome Linked List** (LeetCode 234) - _Find Mid + Reverse_
- [Medium] **Add Two Numbers** (LeetCode 2) - _Math simulation_
- [Medium] **Copy List with Random Pointer** (LeetCode 138) - _Deep Copy / Hash Map_
- [Medium] **Remove Nth Node From End of List** (LeetCode 19) - _Two Pointers Gap_
- [Hard] **Merge k Sorted Lists** (LeetCode 23) - _Heap vs Divide & Conquer_

### 5. [Trees](src/main/java/com/dsa/trees/Trees.md)

- **Focus**: DFS/BFS, BST Properties.
- **Challenge**: `Lowest Common Ancestor (BST)`.

#### Practice Drills

- [Medium] **Binary Tree Level Order Traversal** (LeetCode 102) - _BFS Queue_
- [Medium] **Validate Binary Search Tree** (LeetCode 98) - _Range Validation_
- [Medium] **Construct Binary Tree from Preorder and Inorder** (LeetCode 105) - _Recursion_
- [Medium] **Diameter of Binary Tree** (LeetCode 543) - _DFS Height calculation_
- [Hard] **Binary Tree Maximum Path Sum** (LeetCode 124) - _Global Max updates_

### 6. [Heaps](src/main/java/com/dsa/heaps/Heaps.md)

- **Focus**: Priority Queues, Greedy.
- **Challenge**: `Task Scheduler`.

#### Practice Drills

- [Medium] **K Closest Points to Origin** (LeetCode 973) - _Max Heap for Min K_
- [Medium] **Top K Frequent Elements** (LeetCode 347) - _Min Heap / Bucket Sort_
- [Medium] **Merge Intervals** (LeetCode 56) - _Sorting Start Times_
- [Medium] **Insert Interval** (LeetCode 57) - _Logic Handling_
- [Medium] **Meeting Rooms II** (LeetCode 253) - _Min Heap for End Times_

### 7. [Graphs](src/main/java/com/dsa/graphs/Graphs.md)

- **Focus**: Union-Find, Connectivity.
- **Challenge**: `Number of Provinces`.

#### Practice Drills

- [Medium] **Rotting Oranges** (LeetCode 994) - _Multi-source BFS_
- [Medium] **Redundant Connection** (LeetCode 684) - _Union-Find Cycle Detection_
- [Medium] **Number of Islands** (LeetCode 200) - _Grid DFS/BFS_
- [Medium] **Clone Graph** (LeetCode 133) - _DFS + HashMap Mapping_
- [Medium] **Pacific Atlantic Water Flow** (LeetCode 417) - _DFS from borders_

### 8. [Dynamic Programming](src/main/java/com/dsa/dp/DynamicProgramming.md)

- **Focus**: 1D DP.
- **Challenge**: `Coin Change`.

#### Practice Drills

- [Medium] **House Robber** (LeetCode 198) - _Standard DP_
- [Medium] **Word Break** (LeetCode 139) - _Boolean DP_
- [Medium] **Longest Increasing Subsequence** (LeetCode 300) - _O(n^2) vs O(n log n)_
- [Medium] **Maximum Product Subarray** (LeetCode 152) - _Track Min & Max_
- [Medium] **Decode Ways** (LeetCode 91) - _Decision Tree_

### 9. [Graphs II](src/main/java/com/dsa/graphs/GraphsII.md)

- **Focus**: Dependencies, DAGs.
- **Pattern**: Kahn's Algorithm (Topological Sort).
- **Challenge**: `Course Schedule II`.

#### Practice Drills

- [Medium] **Course Schedule** (LeetCode 207) - _Cycle Detection_
- [Hard] **Alien Dictionary** (LeetCode 269) - _Build Graph + Topo Sort_
- [Medium] **Course Schedule II** (LeetCode 210) - _Order Return_
- [Hard] **Longest Increasing Path in a Matrix** (LeetCode 329) - _DFS + Memoization (Topo-like)_

### 10. [Advanced Optimization](src/main/java/com/dsa/binarysearch/BinarySearch.md)

- **Focus**: Search Space Reduction.
- **Pattern**: Binary Search on Answer.
- **Challenge**: `Koko Eating Bananas`.

#### Practice Drills

- [Medium] **Capacity To Ship Packages Within D Days** (LeetCode 1011) - _Search Answer_
- [Hard] **Split Array Largest Sum** (LeetCode 410) - _Min-Max Search_
- [Medium] **Find Minimum in Rotated Sorted Array** (LeetCode 153) - _Modified BS cond_
- [Medium] **Search in Rotated Sorted Array** (LeetCode 33) - _Pivot Logic_
- [Hard] **Median of Two Sorted Arrays** (LeetCode 4) - _Partitioning_

### 11. [Tries](src/main/java/com/dsa/tries/Trie.md)

- **Focus**: String Prefix Operations.
- **Pattern**: TrieNode with `children[26]`.
- **Challenge**: `Implement Trie`.

#### Practice Drills

- [Medium] **Design Add and Search Words Data Structure** (LeetCode 211) - _DFS within Trie_
- [Hard] **Word Search II** (LeetCode 212) - _Backtracking + Trie_
- [Medium] **Replace Words** (LeetCode 648) - _Root Search_
- [Medium] **Implement Trie (Prefix Tree)** (LeetCode 208) - _Standard_

### 12. [2D Dynamic Programming](src/main/java/com/dsa/dp/2DDP.md)

- **Focus**: Multi-state decision making.
- **Pattern**: Grid Transitions.
- **Challenge**: `Longest Common Subsequence`.

#### Practice Drills

- [Medium] **Unique Paths** (LeetCode 62) - _Grid Counting_
- [Medium] **Edit Distance** (LeetCode 72) - _String Transformation_
- [Medium] **Longest Common Subsequence** (LeetCode 1143) - _Standard 2D_
- [Medium] **Target Sum** (LeetCode 494) - _Knapsack Variation_
- [Hard] **Regular Expression Matching** (LeetCode 10) - _Complex State_

### 13. [System Design (LRU Cache)](src/main/java/com/dsa/systemdesign/SystemDesign.md)

- **Focus**: HashMap + Doubly Linked List.
- **Challenge**: `LRU Cache`.

#### Practice Drills

- [Hard] **LFU Cache** (LeetCode 460) - _Freq Map + multiple lists_
- [Medium] **Design Browser History** (LeetCode 1472) - _Stack / DLL_
- [Medium] **Design Twitter** (LeetCode 355) - _Heap + Map_
- [Medium] **Insert Delete GetRandom O(1)** (LeetCode 380) - _Map + ArrayList_

### 14. [Monotonic Queue (Deque)](src/main/java/com/dsa/deque/MonotonicQueue.md)

- **Focus**: Sliding Window Optimization.
- **Pattern**: Decreasing Deque.
- **Challenge**: `Sliding Window Maximum`.

#### Practice Drills

- [Medium] **Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit** (LeetCode 1438) - _Min & Max Deques_
- [Hard] **Max Value of Equation** (LeetCode 1499) - _Equation Optimization_
- [Hard] **Sliding Window Maximum** (LeetCode 239) - _Standard Deque_
- [Medium] **Shortest Subarray with Sum at Least K** (LeetCode 862) - _Prefix Sum + Deque_

### 15. [Backtracking](src/main/java/com/dsa/backtracking/Backtracking.md)

- **Focus**: State Pruning.
- **Pattern**: Choose-Explore-Unchoose.
- **Challenge**: `Permutations`.

#### Practice Drills

- [Medium] **Subsets** (LeetCode 78) - _Pick / Don't Pick_
- [Medium] **Combination Sum** (LeetCode 39) - _Unbounded Knapsack_
- [Medium] **Letter Combinations of a Phone Number** (LeetCode 17) - _String Building_
- [Hard] **N-Queens** (LeetCode 51) - _Constraint validation_
- [Medium] **Palindrome Partitioning** (LeetCode 131) - _String Partition_

### 16. [Bit Manipulation](src/main/java/com/dsa/bitmanipulation/BitManipulation.md)

- **Focus**: XOR Properties.
- **Pattern**: Low-level Optimization.
- **Challenge**: `Single Number`.

#### Practice Drills

- [Easy] **Number of 1 Bits** (LeetCode 191) - _Hamming Weight_
- [Easy] **Counting Bits** (LeetCode 338) - _DP + Bits_
- [Easy] **Missing Number** (LeetCode 268) - _XOR vs Sum_
- [Easy] **Reverse Bits** (LeetCode 190) - _Bit Shifting_
- [Medium] **Sum of Two Integers** (LeetCode 371) - _Addition without +_

### [Golden List & Checklist](GOLDEN_LIST.md)

Review this before every interview.

---

## How to Run Code

```bash
# Example: Running the Arrays Module
javac src/main/java/com/dsa/arrays/SubarraySum.java
java -cp src/main/java com.dsa.arrays.SubarraySum
```
