# Dynamic Programming

## 🧠 Theory High-Level

**Dynamic Programming** is an optimization over recursion. It solves complex problems by breaking them into overlapping subproblems and storing the results (**Memoization/Tabulation**) to avoid redundant work.
SDE-2 interviews focus on **1D DP** (Linear) and **2D DP** (Grid/Knapsack).

## 🔑 SDE-2 Pattern: Unbounded Knapsack (1D DP)

Whenever you see "Optimization" (Min/Max) + "Choices" + "Overlapping Subproblems", think DP.

- **Formula**: `dp[i] = op(dp[i], dp[i - choice] + cost)`
  - `op`: min, max, or sum.
  - `choice`: usually iterating through an array of items (coins, weights).

## ⚔️ The Challenge: Coin Change

**Problem**: Given coins `[c1, c2, ...]` and `Amount`, find the **minimum** number of coins to make that amount. You can use each coin infinitely.

### Logic (Bottom-Up)

1.  Define `dp[i]` = Min coins to make amount `i`.
2.  Initialize `dp` array with `Amount + 1` (Infinity). `dp[0] = 0`.
3.  Iterate amount `i` from `1` to `Amount`.
4.  For each coin `c`:
    - If `c <= i`: `dp[i] = min(dp[i], dp[i - c] + 1)`.
5.  If `dp[Amount] > Amount`, return `-1`.

## 💻 Code Solution

See [CoinChange.java](CoinChange.java) for the implementation.

# 2D Dynamic Programming

## 🧠 Theory High-Level

**2D DP** involves filling a grid (table) where each cell `dp[i][j]` depends on previous cells (left, top, or diagonal).
Commonly used for problems involving **Two Strings** (LCS, Edit Distance) or **Grids** (Unique Paths).

## 🔑 SDE-2 Pattern: The Decision Table

1.  **Definitions**: What does `dp[i][j]` mean? (e.g., Length of LCS for first `i` chars of S1 and first `j` chars of S2).
2.  **Transitions**:
    - If `S1[i] == S2[j]`: usually `1 + dp[i-1][j-1]` (Diagonal).
    - Else: `max(dp[i-1][j], dp[i][j-1])` (Skip char from S1 or Skip char from S2).

## ⚔️ The Challenge: Longest Common Subsequence

**Problem**: Given `text1` and `text2`, return the length of their longest common subsequence.

### Logic

- Create `dp[m+1][n+1]`.
- Iterate `i` from 1 to `m`, `j` from 1 to `n`.
- If `text1[i-1] == text2[j-1]`: Match found! `dp[i][j] = 1 + dp[i-1][j-1]`.
- Else: No match. Inherit best from Top or Left. `dp[i][j] = Math.max(...)`.

## 💻 Code Solution

See [LongestCommonSubsequence.java](LongestCommonSubsequence.java).
