# Binary Search (Optimization)

## 🧠 Theory High-Level

**Binary Search** is typically taught for finding an element in a sorted array in **O(log n)**.
However, for senior engineering roles, the focus shifts to **Binary Search on Answer**.
This applies when the answer space is monotonic (e.g., if `x` is valid, all `y > x` are also valid, or vice versa). We search for the boundary.

## 🔑 Key Interview Pattern: Binary Search on Answer Space

Instead of searching an array, we search the **Range of Possible Answers** `[Min, Max]`.

- **Left**: Smallest possible answer.
- **Right**: Largest possible answer.
- **Mid**: Candidate answer. Check if `Mid` is valid (using a helper function).
  - If valid: Try to find a better one (move `Right` or `Left` depending on goal).
  - If invalid: Discard half the space.

## ⚔️ The Challenge: Koko Eating Bananas

**Problem**: Koko loves bananas. There are `piles` of bananas. She has `h` hours to eat all. Find minimum integer `k` (speed) such that she can eat all bananas within `h` hours.

### Logic

1.  **Range**:
    - Min speed: `1`
    - Max speed: `Max(piles)` (eating more than the largest pile per hour doesn't help).
2.  **Binary Search**:
    - `mid = (left + right) / 2`.
    - If `canEatAll(mid)` is true:
      - This speed works. Can we go slower? `right = mid`.
    - Else:
      - Too slow. Need higher speed. `left = mid + 1`.
3.  **Helper Function** `canEatAll(speed)`:
    - Iterate piles. Time taken = `Math.ceil(pile / speed)`.
    - Total time <= `h`.

## 💻 Code Solution

See [KokoEatingBananas.java](KokoEatingBananas.java).
