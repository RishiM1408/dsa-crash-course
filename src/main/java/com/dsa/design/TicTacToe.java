package com.dsa.design;

/**
 * Design Tic-Tac-Toe (LeetCode 348)
 * 
 * Assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical,
 * or diagonal row wins the game.
 * 
 * Optimisation: O(1) move using counters.
 */
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     *         0: No one wins.
     *         1: Player 1 wins.
     *         2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd = (player == 1) ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col) {
            diagonal += toAdd;
        }

        if (col == (n - row - 1)) {
            antiDiagonal += toAdd;
        }

        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0;
    }
}
