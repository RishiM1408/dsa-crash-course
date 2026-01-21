# System Design (LRU Cache)

## 🧠 Theory High-Level

**System Design** in SDE-2 interviews often tests your ability to combine multiple data structures to achieve optimal time complexity for specific operations.
An **LRU (Least Recently Used) Cache** is a cache eviction policy where we discard the least recently used items first.

To achieve **O(1)** operations for both `get` and `put`, we need:

1.  **Fast Lookups**: HashMap.
2.  **Fast Ordering Updates**: Doubly Linked List (to move items to the front/back in O(1)).

## 🔑 SDE-2 Pattern: HashMap + Doubly Linked List

- **HashMap**: Stores `Key -> Node`. This gives us O(1) access to any node in the linked list.
- **Doubly Linked List**: Maintains the order of elements.
  - **Head**: Most Recently Used (MRU).
  - **Tail**: Least Recently Used (LRU).

## ⚔️ The Challenge: LRU Cache

**Problem**: Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement `LRUCache(int capacity)`:

- `int get(int key)`: Return value if present, else -1.
- `void put(int key, int value)`: Update if present. Add if not. If capacity exceeded, evict the LRU item.

### Logic

1.  **Get(key)**:
    - Check HashMap. If missing, return -1.
    - If present, **Move Node to Head** (Mark as MRU).
    - Return value.

2.  **Put(key, value)**:
    - If key exists: Update value, **Move Node to Head**.
    - If key missing:
      - Create new Node.
      - Add to HashMap and **Insert at Head**.
      - **Check Capacity**: If `Size > Capacity`:
        - **Remove Tail Node** (LRU).
        - Remove from HashMap.

## 💻 Code Solution

See [LRUCache.java](LRUCache.java) for the implementation.
