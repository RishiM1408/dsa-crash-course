package com.dsa.bitmanipulation;

/**
 * LeetCode 190: Reverse Bits
 *
 * Pattern: Bit Manipulation
 * Iterate 32 bits. Shift result left, add last bit of n.
 */
public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solver = new ReverseBits();

        // Test Case 1: 43261596 (00000010100101000001111010011100) -> 964176192
        // (00111001011110000010100101000000)
        System.out.println("Test Case 1: " + (solver.reverseBits(43261596) == 964176192 ? "PASS" : "FAIL"));
    }
}
