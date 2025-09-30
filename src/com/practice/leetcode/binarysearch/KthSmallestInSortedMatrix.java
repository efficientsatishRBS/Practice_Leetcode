package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Leetcode 378 Medium
 * 
 * Outer Binary Search while (low < high)
 * 
 * 
 * The search space is the range of values in the matrix: [matrix[0][0],
 * matrix[n-1][n-1]] → let's call this range = max - min.
 * 
 * Each iteration halves the range, so the number of iterations is:
 * 
 * 𝑂 ( log ⁡ ( max − min ) ) O(log(max−min)) Counting ≤ mid
 * countLessEqual(matrix, mid, n)
 * 
 * 
 * We use the staircase method: start from bottom-left and move up or right.
 * 
 * Each move either decreases row by 1 or increases col by 1.
 * 
 * Total moves = at most n + n = 2n → O(n)
 * 
 * ️Total Time Complexity
 * 
 * For each binary search iteration, we do countLessEqual → O(n)
 * 
 * Number of iterations → O(log(range))
 * 
 * Time Complexity = 𝑂 ( 𝑛 ⋅ log ⁡ ( max − min ) )
 * Time Complexity=O(n⋅log(max−min))
 * 
 * Note: range = matrix[n-1][n-1] - matrix[0][0]
 * 
 * Space Complexity
 * 
 * Only a few pointers and counters are used (row, col, count)
 * 
 * Space Complexity = O(1) (constant extra space)
 */
public class KthSmallestInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;

		// Search space = smallest value .. largest value
		int low = matrix[0][0]; // smallest element
		int high = matrix[n - 1][n - 1]; // largest element

		while (low < high) {
			int mid = low + (high - low) / 2;

			// Count how many numbers in matrix are <= mid
			int count = countLessEqual(matrix, mid, n);

			if (count < k) {
				// Not enough numbers ≤ mid → kth smallest must be bigger
				low = mid + 1;
			} else {
				// Enough numbers ≤ mid → mid could be answer
				// shrink right boundary to find smaller possible candidate
				high = mid;
			}
		}

		// At this point, low == high → the kth smallest element
		return low;
	}

	// Count how many elements in the matrix are ≤ mid
	private int countLessEqual(int[][] matrix, int mid, int n) {
		int count = 0;
		int row = n - 1; // start at bottom-left corner
		int col = 0;

		while (row >= 0 && col < n) {
			if (matrix[row][col] <= mid) {
				// All elements above in this column are also ≤ mid
				count += row + 1;
				col++; // move right to next column
			} else {
				// Current element > mid → move up to smaller values
				row--;
			}
		}

		return count;
	}

}
