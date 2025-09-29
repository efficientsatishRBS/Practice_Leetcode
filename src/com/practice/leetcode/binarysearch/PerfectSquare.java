package com.practice.leetcode.binarysearch;

/**
 * How it works
 * 
 * Initialize search range: l = 1, r = num.
 * 
 * Repeatedly compute mid = (l + r)/2.
 * 
 * Compare mid * mid (stored in a long to avoid overflow) with num:
 * 
 * If equal → return true.
 * 
 * If greater → shrink right boundary (r = mid - 1).
 * 
 * If smaller → shrink left boundary (l = mid + 1).
 * 
 * If loop ends without finding exact square, return false.
 * 
 * https://leetcode.com/problems/valid-perfect-square/description/ Easy Leetcode 367
 * 
 * Complexity
 * 
 * Time: O(log n) (binary search).
 * 
 * Space: O(1) (only a few variables used).
 * 
 */
public class PerfectSquare {

	public boolean isPerfectSquare(int num) {

		int target = num;

		int l = 1;
		int r = num;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			// Using long for mid * mid prevents integer overflow
			long number = (long) mid * mid;
			if (number == target) {
				return true;
			}
			if (number > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return false;

	}

}
