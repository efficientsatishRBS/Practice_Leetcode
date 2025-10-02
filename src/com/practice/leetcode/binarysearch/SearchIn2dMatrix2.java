package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/ Medium
 * Leetcode 240 Time Complexity = O(m + n)
 * 
 * Space Complexity = O(1) → no extra data structures used.
 * 
 * Let’s carefully analyze why the time complexity is O(m + n) for this
 * top-right (or bottom-left) search.
 * 
 * Setup
 * 
 * Matrix dimensions: m rows × n columns.
 * 
 * We start at top-right: matrix[0][n-1].
 * 
 * At each step, we either:
 * 
 * Move left → eliminate a column
 * 
 * Move down → eliminate a row
 * 
 * Key observation
 * 
 * Every move reduces either the number of rows or columns left to search by 1.
 * 
 * Initially: m rows, n columns.
 * 
 * So in the worst case:
 * 
 * You can move left at most n times (crossing all columns).
 * 
 * You can move down at most m times (crossing all rows).
 * 
 * Total steps Max steps = moves left + moves down ≤ n + m
 * 
 * 
 * At each step, you do constant work (compare with target, decide direction).
 * 
 * Conclusion
 * 
 * Time Complexity = O(m + n)
 * 
 * Space Complexity = O(1) → no extra data structures used.
 */
public class SearchIn2dMatrix2 {

	public boolean searchMatrix(int[][] matrix, int target) {

		int rows = matrix.length;
		int columns = matrix[0].length;

		int searchStartColumn = columns - 1;
		int searchStartRow = 0;

		while (searchStartRow < rows && searchStartColumn >= 0) {

			if (matrix[searchStartRow][searchStartColumn] < target) {
				searchStartRow++;
			} else if (matrix[searchStartRow][searchStartColumn] > target) {
				searchStartColumn--;
			} else {
				return true;
			}
		}

		return false;

	}

}
