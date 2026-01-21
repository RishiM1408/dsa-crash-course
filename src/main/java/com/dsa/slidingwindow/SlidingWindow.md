# Two Pointers & Sliding Window

## 🧠 Theory High-Level

**Two Pointers** use two indices to traverse a data structure (usually sorted) to find a pair/range satisfying a condition.
**Sliding Window** is a specific two-pointer technique for finding subarrays (contiguous) that meet a constraint. Instead of re-calculating the entire window, we maintain a valid state and simply **add** the new element on the right and **remove** the old element from the left.

## 🔑 Key Interview Pattern: Dynamic Sliding Window

For harder problems, the window size isn't fixed.

- **Formula**: **Expand** `right` pointer -> **Check** Condition -> **Shrink** `left` pointer (while invalid) -> **Update** Max/Global Result.
- **Optimization**: Check validity in O(1) using auxiliary space (like a frequency map or count array).

## ⚔️ The Challenge: Longest Repeating Character Replacement

**Problem**: Given a string `s` and max `k` replacements, find the longest substring containing the same letter.

### Logic

1.  We want the window to be valid if: `WindowLength - MaxFrequencyChar <= k`.
    - `WindowLength`: Total chars in current window.
    - `MaxFrequencyChar`: Count of the most dominant char in window.
    - If `(Total - Dominant)` chars are <= `k`, we can swap all of them to match the dominant char.
2.  Iterate `right` from 0 to N.
3.  Add `s[right]` to frequency map. Update `maxFreq`.
4.  If `(right - left + 1) - maxFreq > k`, the window is invalid.
    - Shrink from `left`. Remove `s[left]` from counts. Increment `left`.
5.  Update `maxLen`.

## 💻 Code Solution

See [LongestRepeatingCharacterReplacement.java](LongestRepeatingCharacterReplacement.java) for the implementation.
