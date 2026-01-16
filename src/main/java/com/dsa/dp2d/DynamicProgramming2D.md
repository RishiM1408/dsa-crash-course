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
