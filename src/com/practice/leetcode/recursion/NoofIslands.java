package com.practice.leetcode.recursion;

class Solution {
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void solve(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return;
        }

        if (grid[row][column] != '1') {
            return;
        }

        grid[row][column] = '0';
        for (int direction[] : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            solve(grid, newRow, newColumn);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    solve(grid, i, j);
                }
            }
        }

        return count;
    }
}
