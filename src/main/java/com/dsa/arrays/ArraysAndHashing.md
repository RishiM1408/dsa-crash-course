# Arrays & Hashing

## 🧠 Theory High-Level

Arrays provide **O(1) random access** based on index, which is efficient for lookups when the index is known. However, inserting or deleting elements (except at the end) takes **O(n)** time because subsequent elements must be shifted.
**Hashing** (HashMaps/HashSets) uses a hash function to map keys to indices (buckets), allowing for **O(1) average time complexity** for insertion, deletion, and lookup. It trades memory space for speed.

## 🔑 SDE-2 Pattern: Prefix Sums & Difference Arrays

While simple hashing handles frequency counting (e.g., Two Sum, Anagrams), SDE-2 interviews often test **Prefix Sums**.

- **Concept**: Precompute the cumulative sum of the array up to each index.
- **Power**: Allows calculating the sum of any subarray range `[i, j]` in **O(1)** time using the formula: `Sum(i, j) = PrefixSum[j] - PrefixSum[i-1]`.
- **Application**: "Find number of subarrays with sum K", "Range Sum Queries".

## ⚔️ The Challenge: Subarray Sum Equals K

**Problem**: Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals `k`. Use **O(n)** time.

### Naive Approach (O(n²))

Iterate through all possible subarrays (nested loops) and calculate their sum.

```java
for (int i=0; i<n; i++) {
    int sum = 0;
    for (int j=i; j<n; j++) {
        sum += nums[j];
        if (sum == k) count++;
    }
}
```

### Optimal Approach (O(n) - Prefix Sum + HashMap)

Instead of re-calculating sums, we use the equation:
`CurrentSum - PrefixSum = k` => `PrefixSum = CurrentSum - k`

1.  Maintain a running `CurrentSum`.
2.  Store each `CurrentSum` seen so far in a HashMap (Map: `Sum -> Frequency`).
3.  At each step, check if `(CurrentSum - k)` exists in the map.
4.  If it exists, it means there are `Frequency` number of subarrays ending at the current index with sum `k`.

## 💻 Code Solution

See [SubarraySum.java](SubarraySum.java) for the implementation.
