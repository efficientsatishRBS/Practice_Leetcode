package com.practice.leetcode.strings.manipulation;

/**
 * Time Complexity: O(n)
 * 
 * Space Complexity:
 * 
 * With s.trim() → O(n)
 * 
 * Without s.trim() (manual space skipping) → O(1)
 */
public class StringToIntegerATOI {

	public int myAtoi(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		s = s.trim();
		if (s.isEmpty()) {
			return 0;
		}
		int i = 0;
		int n = s.length();
		boolean isNegative = false;

		if (s.charAt(i) == '-' || s.charAt(i) == '+') {
			if (s.charAt(i) == '-') {
				isNegative = true;
			}
			i++;
		}

		int result = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';

			if (result > (Integer.MAX_VALUE - digit) / 10) {
				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			result = result * 10 + digit;
			i++;
		}

		return isNegative ? -result : result;

	}

}
