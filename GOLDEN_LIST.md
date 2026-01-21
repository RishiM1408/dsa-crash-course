# The Golden List: SDE Interview Pattern Review

A consolidated review of all 16 patterns covered in this crash course, with critical edge cases.

| Topic                 | Pattern             | Challenge (LeetCode)   | Critical Edge Case / "Gotcha"                                  |
| :-------------------- | :------------------ | :--------------------- | :------------------------------------------------------------- |
| **1. Arrays**         | Prefix Sum          | Subarray Sum = K       | `Sum` can be negative (don't initialize max/min to 0).         |
| **2. Hashing**        | HashMap Frequency   | Two Sum / Anagrams     | Collision handling (though internal to Java, know it).         |
| **3. Sliding Window** | Dynamic Window      | Longest Repeating Char | Window shrinking logic: `while (invalid) shrink`.              |
| **4. Two Pointers**   | Shrink/Expand       | Container With Water   | `left < right` condition in while loop.                        |
| **5. Stack**          | Monotonic Stack     | Daily Temperatures     | Remaining elements in stack after loop (no greater element).   |
| **6. Linked List**    | Fast/Slow Pointers  | Reorder List           | Handling lists with `0`, `1`, or `2` nodes (Null checks).      |
| **7. Trees**          | DFS (Recursion)     | Max Depth / Invert     | `root == null` base case is standard but easy to miss.         |
| **8. BST**            | BST Property        | LCA of BST             | Balanced vs Unbalanced tree (Skewed tree = O(n)).              |
| **9. Heaps**          | Max-Heap            | Task Scheduler         | `k=0` case or Empty input.                                     |
| **10. Intervals**     | Sorting Start Time  | Merge Intervals        | `[1,4], [4,5]` -> Merge to `[1,5]` (Equality check).           |
| **11. Graphs**        | Union-Find          | Number of Provinces    | Path compression not implemented (O(n) vs O(1)).               |
| **12. DP (1D)**       | Memoization         | Coin Change            | `Amount = 0` (Return 0) vs `Impossible` (Return -1).           |
| **13. Graphs II**     | Topological Sort    | Course Schedule II     | Detecting Cycles (Count of result != Nodes).                   |
| **14. Optimization**  | Binary Search (Ans) | Koko Eating Bananas    | Integer Overflow when calculating `sum` or `mid`.              |
| **15. Tries**         | Prefix Tree         | Implement Trie         | `startsWith` vs `search` (checking `isEnd` flag).              |
| **16. DP (2D)**       | Grid Trav / String  | LCS / Unique Paths     | Boundary conditions (`i=0` or `j=0` rows/cols).                |
| **17. System Design** | HashMap + DLL       | LRU Cache              | Evicting LRU when capacity is 1.                               |
| **18. Deque**         | Monotonic Deque     | Sliding Window Max     | Removing indices out of window bounds.                         |
| **19. Backtracking**  | State Pruning       | Permutations / Subsets | Not removing element after recursive call (`tempList.remove`). |
| **20. Bits**          | XOR                 | Single Number          | Integer limits if using bit shifting on 64-bit numbers.        |

## Clarifying Questions Checklist (Pre-Code)

**Arrays / Strings**

- "Can the input be empty or null?"
- "Are there negative numbers?"
- "Does the array contain duplicates?"

**Graphs**

- "Is the graph directed or undirected?"
- "Can the graph have cycles?"
- "Is the graph connected?"

**Trees**

- "Is it a Binary Search Tree (BST) or a generic Binary Tree?"
- "Can the tree be unbalanced?"

**Linked Lists**

- "Is it singly or doubly linked?"
- "Can I modify the list in-place?"

**Design (LRU/Trie)**

- "Is this code expected to be thread-safe?"
- "What is the scale (Read-heavy vs. Write-heavy)?"
