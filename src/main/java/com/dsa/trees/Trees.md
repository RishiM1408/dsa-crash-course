# Trees & Tries

## 🧠 Theory High-Level

**Trees** are hierarchical structures with a Root node and children. **Tries** (Prefix Trees) are specialized trees for storing strings, optimizing prefix lookups.
SDE-2 interviews focus heavily on **DFS** (Depth First Search) and **BFS** (Breadth First Search) variants.

## 🔑 SDE-2 Pattern: BST Properties & DFS

For Binary Search Trees (BST), the key property is: `Left.Val < Root.Val < Right.Val`.

- **Implication**: You can discard half the tree at every step (like Binary Search).
- **DFS**: Use recursion to traverse deep. `In-Order` traversal of a BST gives sorted values.

## ⚔️ The Challenge: Lowest Common Ancestor (BST)

**Problem**: Find the lowest node in a BST that has both `p` and `q` as descendants.

### Logic (O(h) Time)

Leverage BST property:

1.  Start at `Root`.
2.  If both `p` and `q` are **smaller** than `Root`, the LCA must be in the **Left** subtree.
3.  If both `p` and `q` are **larger** than `Root`, the LCA must be in the **Right** subtree.
4.  If one is smaller and one is larger (element split), then **Root** is the LCA.

## 💻 Code Solution

See [LowestCommonAncestor.java](LowestCommonAncestor.java) for the implementation.
