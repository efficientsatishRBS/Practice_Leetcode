package com.practice.leetcode.recursion;

/**
 * https://leetcode.com/problems/word-search/description/
 * Leetcode 79 Medium
 * O(R×C×3^L)
 * O(L)
 */
public class WordSearch {

	private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private boolean find(int row, int column, char[][] board, int idx, String word) {
		if (idx == word.length()) {
			return true;
		}
		if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
			return false;
		}

		if (board[row][column] != word.charAt(idx)) {
			return false;
		}

		if (board[row][column] == '$') {
			return false;
		}

		char temp = board[row][column];
		board[row][column] = '$';
		for (int[] direction : directions) {
			int newRow = row + direction[0];
			int newColumn = column + direction[1];

			if (find(newRow, newColumn, board, idx + 1, word)) {
				return true;
			}
		}
		board[row][column] = temp;
		return false;
	}

	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int columns = board[0].length;
		int idx = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == word.charAt(idx) && find(i, j, board, idx, word)) {
					return true;
				}
			}
		}

		return false;
	}

}
