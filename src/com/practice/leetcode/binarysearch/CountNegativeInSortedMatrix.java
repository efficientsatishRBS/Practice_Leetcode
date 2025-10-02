package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/ Easy
 * Leetcode 1351 
 * Time Complexity = O(m + n) 
 * Space Complexity = O(1) (just
 * counters).
 * 
 * Think of it this way: each move eliminates either a row or a column from
 * consideration, so you can’t exceed m+n moves total.
 */
public class CountNegativeInSortedMatrix {

	public int countNegatives(int[][] grid) {

		int count = 0;
		int rows = grid.length;
		int columns = grid[0].length;

		int startrow = rows - 1;
		int startColumn = 0;

		while (startrow >= 0 && startColumn < columns) {
			if (grid[startrow][startColumn] < 0) {
				count += columns - startColumn;
				startrow--;
			} else {
				startColumn++;
			}
		}

		return count;

	}

}
