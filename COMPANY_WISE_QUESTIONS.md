# 🏢 Company-Wise DSA Question Bank

This document classifies frequently asked DSA patterns, HLD/LLD questions for top tech companies.
Use this to prioritize your revision based on your target company.

> **Legend**: 🔗 = Link to solution in this repository.

---

## 🚀 Tier 1: The Giants

### 1. Amazon

**Archetype**: Leadership Principles + Scalable Systems + Graphs/Trees.
**Focus**: BFS, Tree traversals, Sliding Window.

#### 🔥 Top DSA Questions

| Priority | Pattern            | Question / Link                                                                                                                                                           |
| :------- | :----------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **High** | **BFS / Graphs**   | [Number of Islands](src/main/java/com/dsa/graphs/NumberOfIslands.java), [Symmetric Tree](src/main/java/com/dsa/trees/SymmetricTree.java)                                  |
| **High** | **Trees**          | [Lowest Common Ancestor](src/main/java/com/dsa/trees/LowestCommonAncestor.java), [Zigzag Traversal](src/main/java/com/dsa/trees/BinaryTreeZigzagLevelOrderTraversal.java) |
| **Med**  | **Sliding Window** | [Longest Repeating Character Replacement](src/main/java/com/dsa/slidingwindow/LongestRepeatingCharacterReplacement.java)                                                  |
| **Med**  | **Arrays**         | [Group Anagrams](src/main/java/com/dsa/arrays/GroupAnagrams.java), [Product of Array Except Self](src/main/java/com/dsa/arrays/ProductOfArrayExceptSelf.java)             |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design Amazon.com (Shopping Cart), detailed Prime Video streaming architecture.
- **LLD**: Design a **Vending Machine**, **Parking Lot**, or **Locker System**.

---

### 2. Google

**Archetype**: Dynamic Programming + Graphs (Hard) + Tries.
**Focus**: Unseen/novel problems, Grid-based Graphs, DP.

#### 🔥 Top DSA Questions

| Priority | Pattern        | Question / Link                                                                                                                                         |
| :------- | :------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **High** | **DP (2D)**    | [Longest Common Subsequence](src/main/java/com/dsa/dp2d/LongestCommonSubsequence.java), [Edit Distance](src/main/java/com/dsa/dp2d/EditDistance.java)   |
| **High** | **Union-Find** | [Redundant Connection](src/main/java/com/dsa/graphs/RedundantConnection.java), [NumberOfProvinces](src/main/java/com/dsa/graphs/NumberOfProvinces.java) |
| **High** | **Tries**      | [Word Search II](src/main/java/com/dsa/tries/WordSearchII.java)                                                                                         |
| **Med**  | **Intervals**  | [Merge Intervals](src/main/java/com/dsa/heaps/MergeIntervals.java)                                                                                      |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design Google Search (Typeahead), Google Maps (Geo-hashing), Google Drive.
- **LLD**: Design a **Calendar System** (booking slots), **Connect 4** Game.

---

### 3. Microsoft

**Archetype**: Standard DSA + Bug-free Code.
**Focus**: Standard problems, perfect edge-case handling.

#### 🔥 Top DSA Questions

| Priority | Pattern          | Question / Link                                                                                                                                                                         |
| :------- | :--------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Trees**        | [Binary Tree Level Order Traversal](src/main/java/com/dsa/trees/BinaryTreeLevelOrderTraversal.java), [Invert Binary Tree](src/main/java/com/dsa/trees/InvertBinaryTree.java)            |
| **High** | **Strings**      | [Reverse Words using Stack](src/main/java/com/dsa/stack/EvaluateReversePolishNotation.java) (closest match), [String Compression](src/main/java/com/dsa/strings/StringCompression.java) |
| **High** | **Linked Lists** | [Copy List with Random Pointer](src/main/java/com/dsa/linkedlist/CopyListWithRandomPointer.java), [Merge k Sorted Lists](src/main/java/com/dsa/linkedlist/MergeKSortedLists.java)       |
| **Med**  | **Matrix**       | [Spiral Matrix](src/main/java/com/dsa/matrix/SpiralMatrix.java), [Search a 2D Matrix](src/main/java/com/dsa/matrix/SearchA2DMatrix.java)                                                |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design Microsoft Teams (Chat), Office Online (Concurrent Editing).
- **LLD**: Design a **Meeting Scheduler**, **Tic-Tac-Toe**.

---

## 🦄 Tier 2: High-Growth Startups / Unicorns

### 4. Sprinklr

**Archetype**: Implementation Heavy + Math/DP.
**Focus**: Complex implementation, Mathematics, DP.

#### 🔥 Top DSA Questions

| Priority | Pattern     | Question / Link                                                                                                                         |
| :------- | :---------- | :-------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **DP**      | [Coin Change](src/main/java/com/dsa/dp/CoinChange.java), [Maximize Score](src/main/java/com/dsa/dp/MaximizeScoreAfterNOperations.java)  |
| **High** | **Heaps**   | [Task Scheduler](src/main/java/com/dsa/heaps/TaskScheduler.java), [Rearrange String](src/main/java/com/dsa/heaps/ReorganizeString.java) |
| **High** | **Strings** | [Minimum Window Substring](src/main/java/com/dsa/slidingwindow/MinimumWindowSubstring.java)                                             |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design a **Social Media Analytics Platform**, Real-time Distributed Counter.
- **LLD**: Design a **Notification System** (Email/SMS/Push), **logger library**.

---

### 5. Rippling

**Archetype**: Practical DSA + Low Level Design (LLD).
**Focus**: Real-world scenarios, Map + Queue, Recursion.

#### 🔥 Top DSA Questions

| Priority | Pattern                      | Question / Link                                                                                                                  |
| :------- | :--------------------------- | :------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Design / Data Structures** | [LRU Cache](src/main/java/com/dsa/design/LRUCache.java), [Time Based Key-Value Store](src/main/java/com/dsa/design/TimeMap.java) |
| **High** | **Recursion**                | [Permutations](src/main/java/com/dsa/backtracking/Permutations.java), [Subsets](src/main/java/com/dsa/backtracking/Subsets.java) |
| **High** | **HashMaps**                 | [Insert Delete GetRandom O(1)](src/main/java/com/dsa/design/InsertDeleteGetRandomO1.java)                                        |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design a **Payroll Processing System** (Batch jobs), Report Generation System.
- **LLD**: Design an **Employee Management System** (Role-based access).

---

### 6. Rubrik

**Archetype**: Concurrency + Systems + Graphs.
**Focus**: Snapshots, Locking, Graph traversals.

#### 🔥 Top DSA Questions

| Priority | Pattern           | Question / Link                                                                                                                             |
| :------- | :---------------- | :------------------------------------------------------------------------------------------------------------------------------------------ |
| **High** | **Topo Sort**     | [Course Schedule II](src/main/java/com/dsa/graphs/CourseScheduleII.java), [Build Order](src/main/java/com/dsa/graphs/CourseScheduleII.java) |
| **High** | **Intervals**     | [Merge Intervals](src/main/java/com/dsa/heaps/MergeIntervals.java), [Meeting Rooms II](src/main/java/com/dsa/heaps/MeetingRoomsII.java)     |
| **Med**  | **Binary Search** | [Search In Rotated Sorted Array](src/main/java/com/dsa/binarysearch/SearchInRotatedSortedArray.java)                                        |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design a **Distributed File System** (GFS), **Backup & Recovery System**.
- **LLD**: Design a **Snapshot Mechanism**, Thread-safe Queue.

---

## 🏎️ Tier 3: Product-First Companies

### 7. Uber

**Archetype**: Grid Graphs + Routing + Intervals.
**Focus**: Maps, Paths, Time Intervals, Scheduling.

#### 🔥 Top DSA Questions

| Priority | Pattern                   | Question / Link                                                                                                                                                   |
| :------- | :------------------------ | :---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Graph (Shortest Path)** | [Network Delay Time](src/main/java/com/dsa/graphs/NetworkDelayTime.java), [Bus Routes](src/main/java/com/dsa/graphs/BusRoutes.java)                               |
| **High** | **Intervals**             | [Meeting Rooms II](src/main/java/com/dsa/heaps/MeetingRoomsII.java)                                                                                               |
| **High** | **Matrix**                | [Number of Islands](src/main/java/com/dsa/graphs/NumberOfIslands.java), [Pacific Atlantic Water Flow](src/main/java/com/dsa/graphs/PacificAtlanticWaterFlow.java) |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **Uber Backend** (Driver matching, Location tracking), Rate Limiter.
- **LLD**: Design a **Pricing Engine** (Surge pricing logic).

---

### 8. Atlassian

**Archetype**: Rate Limiters + Voting Systems + HashMaps.
**Focus**: Features in Jira/Confluence, HashMaps, Heaps.

#### 🔥 Top DSA Questions

| Priority | Pattern      | Question / Link                                                                                                                                    |
| :------- | :----------- | :------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Design**   | [Design Snake Game](src/main/java/com/dsa/design/SnakeGame.java), [Design Leaderboard](src/main/java/com/dsa/design/DesignLeaderboard.java) (mock) |
| **High** | **HashMaps** | [Rank Teams by Votes](src/main/java/com/dsa/sorting/RankTeamsByVotes.java), [Group Anagrams](src/main/java/com/dsa/arrays/GroupAnagrams.java)      |
| **High** | **Heaps**    | [Top K Frequent Elements](src/main/java/com/dsa/heaps/TopKFrequentElements.java)                                                                   |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **Jira** (Task board updates), **Rate Limiter**.
- **LLD**: Design a **Voting System**, **Tagging System**.

---

## 🌎 Tier 4: Global Tech Leaders

### 9. Meta (Facebook)

**Archetype**: Graph Heavy + Fast Coding.
**Focus**: Speed, Arrays, Graphs.

#### 🔥 Top DSA Questions

| Priority | Pattern    | Question / Link                                                                                                                                                        |
| :------- | :--------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Arrays** | [Subarray Sum Equals K](src/main/java/com/dsa/arrays/SubarraySum.java), [Merge Sorted Array](src/main/java/com/dsa/arrays/MergeSortedArray.java)                       |
| **High** | **Graphs** | [Number of Islands](src/main/java/com/dsa/graphs/NumberOfIslands.java), [Shortest Path in Binary Matrix](src/main/java/com/dsa/graphs/ShortestPathInBinaryMatrix.java) |
| **High** | **Trees**  | [Diameter of Binary Tree](src/main/java/com/dsa/trees/DiameterOfBinaryTree.java), [BST to Circular DLL](src/main/java/com/dsa/trees/BSTToDoublyLinkedList.java)        |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **News Feed**, **Facebook Messenger**, **Instagram Stories**.
- **LLD**: Design a **Comment System** (Nested comments).

---

### 10. Netflix

**Archetype**: Culture-Fit + System Design + Caching.
**Focus**: Grouping, Caching, Efficiency.

#### 🔥 Top DSA Questions

| Priority | Pattern      | Question / Link                                                                                                                 |
| :------- | :----------- | :------------------------------------------------------------------------------------------------------------------------------ |
| **High** | **Design**   | [LRU Cache](src/main/java/com/dsa/design/LRUCache.java), [In-Memory File System](src/main/java/com/dsa/design/FileSystem.java)  |
| **High** | **Grouping** | [Group Anagrams](src/main/java/com/dsa/arrays/GroupAnagrams.java)                                                               |
| **Med**  | **Stacks**   | [Max Stack](src/main/java/com/dsa/design/MaxStack.java), [Basic Calculator](src/main/java/com/dsa/stack/BasicCalculatorII.java) |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **Netflix Video Streaming** (CDN, Adaptive Bitrate), Recommendation System.
- **LLD**: Design a **Movie Rating Service**.

---

### 11. Apple

**Archetype**: Team-Specific.
**Focus**: Strings, Arrays, HashMaps.

#### 🔥 Top DSA Questions

| Priority | Pattern          | Question / Link                                                                                                                                                                                                      |
| :------- | :--------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Arrays**       | [Two Sum](src/main/java/com/dsa/arrays/TwoSum.java) (if exists, else [3Sum](src/main/java/com/dsa/arrays/ThreeSum.java)), [Product of Array Except Self](src/main/java/com/dsa/arrays/ProductOfArrayExceptSelf.java) |
| **High** | **Strings**      | [Longest Substring Without Repeating Characters](src/main/java/com/dsa/slidingwindow/LongestSubstringWithoutRepeatingCharacters.java)                                                                                |
| **High** | **Linked Lists** | [Add Two Numbers](src/main/java/com/dsa/linkedlist/AddTwoNumbers.java)                                                                                                                                               |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **iCloud Photo Sync**, **App Store**.
- **LLD**: Design a **Music Player** playlist management.

---

### 12. Salesforce

**Archetype**: Enterprise Logic + SQL.
**Focus**: OOP Design, Standard DSA, SQL.

#### 🔥 Top DSA Questions

| Priority | Pattern    | Question / Link                                                                                                        |
| :------- | :--------- | :--------------------------------------------------------------------------------------------------------------------- |
| **High** | **Trees**  | [Symmetric Tree](src/main/java/com/dsa/trees/SymmetricTree.java), [Path Sum](src/main/java/com/dsa/trees/PathSum.java) |
| **High** | **Arrays** | [Merge Intervals](src/main/java/com/dsa/heaps/MergeIntervals.java)                                                     |
| **Med**  | **Heaps**  | [Kth Largest Element in an Array](src/main/java/com/dsa/heaps/KthLargestElementInAnArray.java)                         |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design a **CRM System**, **Real-time Collaboration Tool**.
- **LLD**: Design an **Elevator System** (classic OOP).

---

### 13. Adobe

**Archetype**: Mathematical + Logic.
**Focus**: Geometry, String parsing, Linked Lists.

#### 🔥 Top DSA Questions

| Priority | Pattern          | Question / Link                                                                                                                                                                     |
| :------- | :--------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Linked Lists** | [Add Two Numbers II](src/main/java/com/dsa/linkedlist/AddTwoNumbersII.java), [Intersection of Two Linked Lists](src/main/java/com/dsa/linkedlist/IntersectionOfTwoLinkedLists.java) |
| **High** | **Math / Bits**  | [Single Number](src/main/java/com/dsa/bitmanipulation/SingleNumber.java), [Reverse Integer](src/main/java/com/dsa/math/ReverseInteger.java) (mock)                                  |
| **High** | **Trees**        | [Binary Tree Zigzag Level Order Traversal](src/main/java/com/dsa/trees/BinaryTreeZigzagLevelOrderTraversal.java)                                                                    |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **Google Analytics** (similar to Adobe Analytics).
- **LLD**: Design a **LRU Cache** (Library level).

---

## 🚀 Tier 5: Specialized & High-Bar

### 14. LinkedIn

**Archetype**: Nested Structures + Concurrency.
**Focus**: Nested problems, Retain Best Cache.

#### 🔥 Top DSA Questions

| Priority | Pattern       | Question / Link                                                                                                                                                  |
| :------- | :------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Recursion** | [Nested List Weight Sum](src/main/java/com/dsa/recursion/NestedListWeightSum.java), [Max Depth of N-ary Tree](src/main/java/com/dsa/trees/MaxDepthNaryTree.java) |
| **High** | **Design**    | [Max Stack](src/main/java/com/dsa/design/MaxStack.java), [Retain Best Cache](src/main/java/com/dsa/design/RetainBestCache.java)                                  |
| **High** | **Graphs**    | [Find the Celebrity](src/main/java/com/dsa/graphs/FindTheCelebrity.java)                                                                                         |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **LinkedIn Connections** (Graph Service), **Feed Ranking**.
- **LLD**: Design a **Calendar Invite System**.

---

### 15. Airbnb

**Archetype**: BFS/DFS + Travel Logic.
**Focus**: Flights, Listings, Palindromes.

#### 🔥 Top DSA Questions

| Priority | Pattern     | Question / Link                                                                                                                                                   |
| :------- | :---------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Graphs**  | [Cheapest Flights Within K Stops](src/main/java/com/dsa/graphs/CheapestFlightsWithinKStops.java)                                                                  |
| **High** | **Strings** | [Palindrome Partitioning](src/main/java/com/dsa/backtracking/PalindromePartitioning.java), [Palindrome Pairs](src/main/java/com/dsa/strings/PalindromePairs.java) |
| **High** | **BFS**     | [Sliding Puzzle](src/main/java/com/dsa/graphs/SlidingPuzzle.java), [Alien Dictionary](src/main/java/com/dsa/graphs/AlienDictionary.java)                          |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **Airbnb Booking System** (Availability checks), **Search Ranking**.
- **LLD**: Design a **Pricing Calendar**.

---

### 16. DoorDash

**Archetype**: Scheduling + Intervals.
**Focus**: Time Intervals, Connectivity, Routing.

#### 🔥 Top DSA Questions

| Priority | Pattern           | Question / Link                                                                                                                                          |
| :------- | :---------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Intervals**     | [Employee Free Time](src/main/java/com/dsa/heaps/EmployeeFreeTime.java), [Meeting Rooms II](src/main/java/com/dsa/heaps/MeetingRoomsII.java)             |
| **High** | **Graphs (Grid)** | [Shortest Path to Get Food](src/main/java/com/dsa/graphs/ShortestPathToGetFood.java), [Walls and Gates](src/main/java/com/dsa/graphs/WallsAndGates.java) |
| **High** | **Design**        | [Design Tic-Tac-Toe](src/main/java/com/dsa/design/TicTacToe.java)                                                                                        |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **DoorDash Delivery Dispatcher**, **Real-time Order Tracking**.
- **LLD**: Design a **Menu Management System**.

---

### 17. Pinterest

**Archetype**: Matrix + Image Processing Logic.
**Focus**: Matrix, Traversals.

#### 🔥 Top DSA Questions

| Priority | Pattern          | Question / Link                                                                                                                          |
| :------- | :--------------- | :--------------------------------------------------------------------------------------------------------------------------------------- |
| **High** | **Matrix**       | [Word Search](src/main/java/com/dsa/backtracking/WordSearch.java), [NumberOfIslands](src/main/java/com/dsa/graphs/NumberOfIslands.java)  |
| **High** | **Backtracking** | [Word Search II](src/main/java/com/dsa/tries/WordSearchII.java)                                                                          |
| **High** | **BFS**          | [Sliding Puzzle](src/main/java/com/dsa/graphs/SlidingPuzzle.java), [Alien Dictionary](src/main/java/com/dsa/graphs/AlienDictionary.java) |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design **Pinterest Image Discovery** (Visual search), **Pin Board**.
- **LLD**: Design an **Image Filter System**.

---

### 18. Coinbase

**Archetype**: Crypto/Finance + HashMaps.
**Focus**: Transactions, Ledgers.

#### 🔥 Top DSA Questions

| Priority | Pattern     | Question / Link                                                                                                           |
| :------- | :---------- | :------------------------------------------------------------------------------------------------------------------------ |
| **High** | **Design**  | [Design Hit Counter](src/main/java/com/dsa/design/HitCounter.java), [KV Store](src/main/java/com/dsa/design/TimeMap.java) |
| **High** | **Graph**   | [Evaluate Division](src/main/java/com/dsa/graphs/EvaluateDivision.java)                                                   |
| **High** | **HashMap** | [Subarray Sum Equals K](src/main/java/com/dsa/arrays/SubarraySum.java)                                                    |

#### 🏗️ System Design (HLD & LLD)

- **HLD**: Design a **Crypto Exchange** (Order Matching Engine), **Digital Wallet**.
- **LLD**: Design a **Currency Converter**.
