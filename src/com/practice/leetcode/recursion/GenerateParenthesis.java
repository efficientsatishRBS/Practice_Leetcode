package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Leetcode 22 Medium
 * TC - O(2^n)
 * SC - O(2*n) depth of the recursion stack
 * 
 * Total places = 2*n
 * As we have 2 options for each 2*n places So time complexity is 2*2^n
 */

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {

		List<String> result = new ArrayList<>();
		solve("", n, 0, 0, result);

		return result;

	}

	private void solve(String curr, int n, int open, int close, List<String> result) {
		if (curr.length() == 2 * n) {
			result.add(curr);
			return;
		}

		if (open < n) {
			curr += "(";
			solve(curr, n, open + 1, close, result);
			curr = curr.substring(0, curr.length() - 1);
		}

		if (close < open) {
			curr += ")";
			solve(curr, n, open, close + 1, result);
			curr = curr.substring(0, curr.length() - 1);
		}
	}

}
