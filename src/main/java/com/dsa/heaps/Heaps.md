# Heaps & Intervals

## 🧠 Theory High-Level

**Heaps** (Priority Queues) are binary trees that maintain the property: `Parent` is always smaller (Min-Heap) or larger (Max-Heap) than children. Good for "Get Min/Max" in O(1).
**Intervals** problems involve dealing with overlapping time ranges, often requiring sorting by start time.

## 🔑 Key Interview Pattern: Greedy Priority Queue

Whenever you need to "process tasks by priority" or "merge items continuously", think **Heap**.

- **Time Complexity**: Insertion/Deletion is **O(log n)**. Pushing `n` items takes **O(n log n)**.
- **Strategy**: Use a Max-Heap to always grab the "most urgent" or "largest available" resource.

## ⚔️ The Challenge: Task Scheduler

**Problem**: Given tasks `[A, A, B, B]` and cooldown `n`, find minimum time to execute all. Same tasks must be separated by `n` units.

### Logic (Greedy)

1.  Count frequencies. `A:3, B:3`.
2.  Schedule the **most frequent** task first (`A`). This creates the "frame" or "skeleton" of the schedule.
    - `A -> idle -> A -> idle -> A`
3.  Fill the idle spots with the next most frequent tasks (`B`).
    - `A -> B -> A -> B -> A -> B`
4.  **Math Formula**:
    - `MaxIdleTime = (MaxFreq - 1) * n`
    - Subtract `min(MaxFreq - 1, Freq[i])` for other tasks.
    - `Result = Tasks.Length + UnfilledIdleTime`.

## 💻 Code Solution

See [TaskScheduler.java](TaskScheduler.java) for the implementation.
