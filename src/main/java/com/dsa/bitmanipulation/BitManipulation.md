# Bit Manipulation

## 🧠 Theory High-Level

**Bit Manipulation** involves manipulating integers at the binary level. It is essential for:

- **Space Optimization**: Storing booleans/flags in a single integer.
- **Performance**: Bitwise operations are faster than arithmetic.
- **Unique Properties**: especially **XOR** (`^`).

## 🔑 Key Interview Pattern: XOR Properties

XOR is the most common bitwise tool in interviews.
Properties:

1.  `a ^ a = 0` (Self-inverse)
2.  `a ^ 0 = a` (Identity)
3.  `a ^ b = b ^ a` (Commutative)

## ⚔️ The Challenge: Single Number

**Problem**: Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.
Constraint: Linear time `O(n)` and constant extra space `O(1)`.

### Logic

If we XOR all numbers together:

- Pairs cancel out (`a ^ a = 0`).
- `0 ^ x = x`.
- The result will be the single number.

Example: `[4, 1, 2, 1, 2]`
Calculation: `4 ^ 1 ^ 2 ^ 1 ^ 2`
Rearranged: `(1 ^ 1) ^ (2 ^ 2) ^ 4`
Result: `0 ^ 0 ^ 4 = 4`.

## 💻 Code Solution

See [SingleNumber.java](SingleNumber.java).
