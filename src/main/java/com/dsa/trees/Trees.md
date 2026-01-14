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

# Tree Refinement: Generic LCA

## 🧠 Theory High-Level

Finding the Lowest Common Ancestor (LCA) changes depending on the tree type:

- **BST**: Use property `L < Root < R`. Time O(h).
- **Generic Binary Tree**: No property to guide us. Must visit **every node** in worst case. Time O(n).

## 🔑 SDE-2 Pattern: Post-Order Traversal

We need to determine if `p` or `q` exists in the subtrees.

1.  Visit Left. Visit Right.
2.  If **Left and Right** both return a non-null node, then the **Current Root** is the LCA (because `p` is on one side and `q` on the other).
3.  If only one side returns non-null, pass that up (it means LCA is higher up, or we found one of the nodes).

## ⚔️ The Challenge: LCA of Binary Tree

**Problem**: Given a binary tree (not BST), find LCA of `p` and `q`.

### Logic

- Base Case: If `root == null` OR `root == p` OR `root == q`, return `root`.
- Recursive Step:
  - `l = lca(root.left, p, q)`
  - `r = lca(root.right, p, q)`
- Merge Step:
  - If `l != null` AND `r != null`, return `root`.
  - Else return the non-null one.

## 💻 Code Solution

See [LowestCommonAncestorGeneric.java](LowestCommonAncestorGeneric.java).
