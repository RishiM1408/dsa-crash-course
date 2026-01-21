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

## Foundational Topics

### 1. Modulo Arithmetic

When dealing with large numbers (like $10^9 + 7$), use these properties:

- `(a + b) % m = ((a % m) + (b % m)) % m`
- `(a * b) % m = ((a % m) * (b % m)) % m`
- `(a - b) % m = ((a % m) - (b % m) + m) % m` (Add `m` to handle negative results)

### 2. Greatest Common Divisor (GCD) & LCM

- **GCD(a, b)**: Largest number that divides both `a` and `b`.
- **Euclidean Algorithm**: `gcd(a, b) = gcd(b, a % b)` until `b == 0`.
- **LCM(a, b)**: `(a * b) / gcd(a, b)`.

### 3. Prime Factorization & Sieve

- **Prime Check**: Iterate from `2` to `√n`. If `n % i == 0`, it's composite.
- **Sieve of Eratosthenes**: Efficiently finds all primes up to `n`.
- **Prime Factorization**: Repeatedly divide `n` by its smallest factor (starting from 2).

### 4. Combinatorics

- **Permutations (nPr)**: Arranging `r` items from `n`. `n! / (n-r)!`.
- **Combinations (nCr)**: Choosing `r` items from `n`. `n! / (r! * (n-r)!)`.
  - Use Pascal's Triangle for DP-based `nCr`.

### 5. Geometry Basics

- **Distance Formula**: `√((x2-x1)² + (y2-y1)²)`
- **Slope**: `(y2-y1) / (x2-x1)` (Watch out for division by zero!)
- **Collinearity**: Three points `a, b, c` are collinear if `slope(a, b) == slope(b, c)`.
  - Cross Product form to avoid division: `(y2-y1)*(x3-x2) == (y3-y2)*(x2-x1)`.
