package com.dsa.dp;

import java.util.Arrays;

/**
 * Topic: Dynamic Programming (1D)
 * Problem: Coin Change
 * LeetCode: 322
 * Complexity: O(amount * n) Time | O(amount) Space
 */
public class CoinChange {

    /**
     * Finds the minimum number of coins needed to make up the amount.
     * 
     * Logic:
     * dp[i] = min coins to make amount 'i'
     * dp[i] = min(dp[i], dp[i - coin] + 1) for coin in coins
     * Base case: dp[0] = 0
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println("Min coins for 11: " + solver.coinChange(coins, amount));
        // Expected: 3 (5 + 5 + 1)
    }
}
