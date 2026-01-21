# Mathematics

Mathematics questions in coding interviews usually revolve around number theory, modular arithmetic, and geometric properties.
Key concepts: **Prime Factorization**, **GCD/LCM**, **Modulo Operations**, **Sieve of Eratosthenes**, and **Combinatorics**.

> **Pattern**: Use Sieve for Primes, Euclidean Algorithm for GCD.

## Challenge: Count Primes

Given an integer `n`, return the number of prime numbers that are strictly less than `n`.

**Naive**: Check `isPrim(i)` for all `i` -> O(n√n)
**Optimal**: Sieve of Eratosthenes -> O(n log log n)

## Practice Drills

- [Medium] **Count Primes** (LeetCode 204) - _Sieve of Eratosthenes_
- [Medium] **Pow(x, n)** (LeetCode 50) - _Binary Exponentiation_
- [Easy] **Greatest Common Divisor of Strings** (LeetCode 1071) - _GCD Logic_
- [Medium] **Rotate Image** (LeetCode 48) - _Matrix Math_
- [Medium] **Reverse Integer** (LeetCode 7) - _Overflow Handling_
- [Medium] **Multiply Strings** (LeetCode 43) - _BigInt Simulation_
