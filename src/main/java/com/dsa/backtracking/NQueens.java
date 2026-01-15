package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 51: N-Queens
 *
 * Pattern: Backtracking
 * Place queen row by row. Check validity.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(board, 0, result);
        return result;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> result) {
        if (colIndex == board.length) {
            result.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, result);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        // Test Case 1: n=4 -> 2 solutions
        List<List<String>> res = solver.solveNQueens(4); // Fixed to use instance method
        System.out.println("Test Case 1: " + (res.size() == 2 ? "PASS" : "FAIL (Got " + res.size() + ")"));
    }
}
