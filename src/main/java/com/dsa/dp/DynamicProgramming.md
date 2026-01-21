# Dynamic Programming

## 🧠 Theory High-Level

**Dynamic Programming** is an optimization over recursion. It solves complex problems by breaking them into overlapping subproblems and storing the results (**Memoization/Tabulation**) to avoid redundant work.
Technical interviews focus on **1D DP** (Linear) and **2D DP** (Grid/Knapsack).

## 🔑 Key Interview Pattern: Unbounded Knapsack (1D DP)

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
