# System Design DSA: LRU Cache

## 🧠 Theory High-Level

**LRU (Least Recently Used) Cache** is a cache eviction policy where we discard the least recently used items first when the cache is full.
It requires **O(1)** operations for both `Get` (Read) and `Put` (Write/Update).

## 🔑 SDE-2 Pattern: HashMap + Doubly Linked List

A standard Array or List allows O(1) access but O(n) removal/shifting. A Hashmap allows O(1) access but no ordering.
We combine them:

- **HashMap**: Maps `Key -> Node`. Allows O(1) access.
- **Doubly Linked List**: Maintains order of usage. Head = Most Recently Used (MRU). Tail = Least Recently Used (LRU).
- **Logic**:
  - **Access**: Look up Node in Map. Move Node to Head of List.
  - **Add**: Create Node. Add to Head. Put in Map.
  - **Evict**: Remove Node from Tail. Remove from Map.

## ⚔️ The Challenge: LRU Cache

**Problem**: Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

### Logic

1.  Use dummy `head` and `tail` nodes to simplify edge cases (inserting into empty list, etc).
2.  `get(key)`: If exists, move to head. Return value.
3.  `put(key, value)`:
    - If exists, update value, move to head.
    - If new:
      - If capacity full, remove `tail.prev` (LRU), remove from map.
      - Add new node to `head.next` (MRU), add to map.

## 💻 Code Solution

See [LRUCache.java](LRUCache.java).
