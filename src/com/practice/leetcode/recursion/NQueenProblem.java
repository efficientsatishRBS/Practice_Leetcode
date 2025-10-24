package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode.com/problems/n-queens/description/
 * Leetcode 51 hard
 * TC - O(N!)
 * SC - O(n)
 */
class NQueenProblem {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        
        //prepare the board
        char [][] board = new char[n][n];

        for (int i=0;i<n;i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n);

        return result;
    }

    private void solve(char[][] board, int row, int n) {
          if (row >= n) {
            List<String> temp = new ArrayList<>();
            for (int r =0;r<n;r++) {
                temp.add(new String(board[r]));
                
            }
            result.add(temp);
            return;
          }
          
          for (int col=0;col<n;col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, row+1, n);
                board[row][col] = '.';
            }
          }

    }

    private boolean isValid(char[][] board, int row, int col, int n) {
          //check upward in column
          for (int i=row;i>=0;i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
          }

          //check diagonal right in column
          for (int i=row-1, j = col+1;i>=0 && j<n;i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
          }

          //check diagonal left in column
          for (int i=row-1, j = col-1;i>=0 && j>=0;i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
          }

          return true;
    }
    
    public static void main(String[] args) {
    	NQueenProblem nQueenProblem = new NQueenProblem();
    	System.out.println(nQueenProblem.solveNQueens(4));
	}
}
