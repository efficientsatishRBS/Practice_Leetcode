package com.practice.leetcode.strings.manipulation;

/**
 * https://leetcode.com/problems/reverse-integer/ Leetcode 7
 * 
 * Medium Time Complexity: O(log n) → digits processed (constant 10 steps max
 * for 32-bit, so effectively O(1)).
 * 
 * Space Complexity: O(1).
 */
public class ReverseInteger {

	public int reverse(int x) {

		long result = 0;

		while (x != 0) {
			int remainder = x % 10;
			result = result * 10 + remainder;
			if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
				return 0;
			}
			x = x / 10;
		}

		return (int) result;
	}

}
