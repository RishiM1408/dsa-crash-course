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
