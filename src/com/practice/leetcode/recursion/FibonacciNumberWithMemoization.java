package com.practice.leetcode.recursion;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/fibonacci-number/ Easy Leetcode 509
 * 
 * Time Complexity
 * 
 * Without memoization, Fibonacci is O(2^n). But with memoization:
 * 
 * Each state fib(k) for 0 ≤ k ≤ n is computed only once.
 * 
 * When it’s computed, we store it in memo[k].
 * 
 * After that, any future call just returns in O(1).
 * 
 * So, the total number of computations = n.
 * 
 * Time Complexity = O(n)
 * 
 * Space Complexity
 * 
 * We need to count both:
 * 
 * Memoization Array
 * 
 * int memo[] = new int[n+1] → uses O(n) space.
 * 
 * Recursion Stack
 * 
 * The recursive call goes down to fib(0) from fib(n).
 * 
 * The maximum recursion depth = n.
 * 
 * So recursion stack also takes O(n).
 * 
 * Total space = O(n) (memo array) + O(n) (recursion stack) → O(n).
 * 
 * Final Answer
 * 
 * Time Complexity: O(n)
 * 
 * Space Complexity: O(n)
 * 
 */
public class FibonacciNumberWithMemoization {

	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int memo[] = new int[n + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;

		return fib(n, memo);
	}

	private int fib(int n, int[] memo) {
		if (memo[n] != -1) {
			return memo[n];
		}

		int firstNumber = fib(n - 1, memo);
		int secondNumber = fib(n - 2, memo);
		memo[n] = firstNumber + secondNumber;
		return memo[n];
	}

}
