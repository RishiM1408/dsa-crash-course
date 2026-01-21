# Backtracking

## 🧠 Theory High-Level

**Backtracking** is an algorithmic technique for solving problems recursively by trying to build a solution incrementally.
If a partial solution cannot possibly be completed to a valid solution, we **abandon** it (backtrack) and try another path.

## 🔑 Key Interview Pattern: Choose-Explore-Unchoose

To avoid creating new objects (arrays/lists) at every step, we use a single mutable structure and restore its state.

1.  **Choose**: Add an element to the current solution path.
2.  **Explore**: Recursively call the function for the next step.
3.  **Unchoose**: Remove the element (Backtrack) to return to the previous state.

## ⚔️ The Challenge: Permutations

**Problem**: Given distinct integers, return all possible permutations.

### Logic

- Loop through all numbers.
- If number is already used in current path, skip it.
- Add number to path. Recurse.
- Remove number from path.
- Base Case: Path length == Input length.

## 💻 Code Solution

See [Permutations.java](Permutations.java).
