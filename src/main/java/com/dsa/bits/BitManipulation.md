# Bit Manipulation

## 🧠 Theory High-Level

Bit Manipulation exploits the binary representation of data for extreme optimization.
Operators: `&` (AND), `|` (OR), `^` (XOR), `~` (NOT), `<<` (Left Shift), `>>` (Right Shift).

## 🔑 SDE-2 Pattern: XOR Properties

XOR (`^`) is the "magic" operator for SDE-2 problems.

- **Property 1**: `A ^ 0 = A`
- **Property 2**: `A ^ A = 0` (Self-cancellation)
- **Property 3**: `A ^ B ^ A = B` (Order doesn't matter)
- **Usage**: Finding unique elements, missing numbers, or swapping variables without temp.

## ⚔️ The Challenge: Single Number

**Problem**: Non-empty array of integers, every element appears twice except for one. Find that one. Linear time, O(1) space.

### Logic

If we XOR all numbers together:
`[4, 1, 2, 1, 2]`
`= 4 ^ (1 ^ 1) ^ (2 ^ 2)`
`= 4 ^ 0 ^ 0`
`= 4`.
All pairs cancel out, leaving the single number.

## 💻 Code Solution

See [SingleNumber.java](SingleNumber.java).
