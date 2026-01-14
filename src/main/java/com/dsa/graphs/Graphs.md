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

# Graphs II: Topological Sort

## 🧠 Theory High-Level

**Topological Sort** is a linear ordering of vertices in a Directed Acyclic Graph (DAG) such that for every directed edge `u -> v`, vertex `u` comes before `v`.
It is impossible if the graph has a cycle.

## 🔑 SDE-2 Pattern: Kahn's Algorithm (BFS)

While DFS can do Topo Sort, **Kahn's Algorithm** is more intuitive and easier to implement for cycle detection using an **Indegree Array**.

- **Indegree**: Number of incoming edges.
- **Logic**:
  1.  Compute indegree for all nodes.
  2.  Push nodes with `Indegree == 0` to Queue.
  3.  Pop node, add to result, and decrement neighbor's indegree.
  4.  If neighbor's indegree becomes 0, push to Queue.

## ⚔️ The Challenge: Course Schedule II

**Problem**: You have `n` courses and a list of prerequisites. Return the ordering of courses you should take to finish all courses. If impossible, return empty array.

### Logic

Map this to a graph problem:

- Courses = Nodes.
- Prerequisites `[A, B]` means `B -> A` (Must take B before A).
- Run Kahn's Algorithm.
- If `Result.size != n`, there is a cycle (Impossible).

## 💻 Code Solution

See [CourseScheduleII.java](CourseScheduleII.java).
