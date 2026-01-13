# Advanced Optimization: Binary Search on Answer

## 🧠 Theory High-Level

Binary Search is usually taught on "Sorted Arrays". However, for SDE-2, you must apply it to **"Search Spaces"**.
If a function `condition(x)` is monotonic (e.g., F, F, F, T, T, T), you can binary search for the first `T`.

## 🔑 SDE-2 Pattern: Define Range + Predicate

1.  **Define Search Space**: What is the minimum possible answer? What is the maximum? (e.g., `[1, MaxPile]`).
2.  **Define Predicate**: Write a function `boolean canDo(val)` that checks if a guessed answer is valid.
3.  **Binary Search**: Shrink the range based on `canDo(mid)`.

## ⚔️ The Challenge: Koko Eating Bananas

**Problem**: Koko loves bananas. There are `piles` of bananas. She has `h` hours. Find the **minimum speed** `k` (bananas/hour) to eat all.

### Logic

- **Space**: `[1, Max(piles)]`.
- **Predicate**: `canEatAll(speed)`:
  - Calculate hours needed for each pile: `ceil(pile / speed)`.
  - Sum hours. If `sum <= h`, return True.
- **Search**:
  - If `canEatAll(mid)` is True, try smaller speed (`right = mid`).
  - If False, need higher speed (`left = mid + 1`).

## 💻 Code Solution

See [KokoEatingBananas.java](KokoEatingBananas.java).
