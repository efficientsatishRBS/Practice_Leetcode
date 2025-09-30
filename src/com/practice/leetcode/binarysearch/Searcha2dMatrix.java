package com.practice.leetcode.binarysearch;

/**
 * 
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * 
 * Leetcode 74 Medium What it does
 * 
 * Searches for a target value in a 2D matrix where:
 * 
 * Each row is sorted in ascending order.
 * 
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * Returns true if the target exists, otherwise false.
 * 
 * How it works
 * 
 * Treat the 2D matrix as a flattened 1D sorted array of length rows * cols.
 * 
 * Index mid maps to matrix cell:
 * 
 * row = mid / cols
 * 
 * col = mid % cols
 * 
 * Perform standard binary search:
 * 
 * If matrix[row][col] > target, search left half.
 * 
 * If matrix[row][col] < target, search right half.
 * 
 * If equal, return true.
 * 
 * If the loop ends, the element is not present → return false.
 * 
 * Complexity
 * 
 * Time Complexity: O(log(rows * cols)) (binary search over all elements).
 * 
 * Space Complexity: O(1) (only variables used).
 */
public class Searcha2dMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int l = 0;
		int r = rows * cols - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (matrix[row][col] > target) {
				r = mid - 1;
			} else if (matrix[row][col] < target) {
				l = mid + 1;
			} else {
				return true;
			}
		}

		return false;

	}

}
