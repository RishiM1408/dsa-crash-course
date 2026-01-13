# Graphs

## 🧠 Theory High-Level

**Graphs** model relationships (`Edges`) between objects (`Nodes`). They can be Directed/Undirected and Weighted/Unweighted.
Key traversal algorithms:

- **BFS** (Shortest Path in unweighted).
- **DFS** (Exhaustive search/Cycle detection).

## 🔑 SDE-2 Pattern: Union-Find (Disjoint Set)

While standard DFS/BFS is fine for "Is there a path?", **Union-Find** is the SDE-2 weapon for "Dynamic Connectivity" or "Counting Components" efficiently.

- **Operations**: `find(x)`, `union(x, y)`.
- **Optimizations**: Path Compression + Union by Rank -> nearly **O(1)** (Inverse Ackermann function).

## ⚔️ The Challenge: Number of Provinces

**Problem**: Given an `n x n` matrix `isConnected`, where `isConnected[i][j] = 1`, find the total number of provinces (connected groups of cities).

### Logic (Union-Find)

1.  Initialize `n` independent sets (each city is its own parent).
2.  Iterate through the `isConnected` matrix.
3.  If `city_i` and `city_j` are connected:
    - Call `union(i, j)`.
    - If they were in different sets, merge them and decrement `Count`.
4.  Return final `Count`.

## 💻 Code Solution

See [NumberOfProvinces.java](NumberOfProvinces.java) for the implementation.
