package com.practice.leetcode.recursion;

/**
 * https://www.geeksforgeeks.org/problems/factorial5739/1
 * 
 * Time Complexity
 * 
 * For factorial(n), the function calls factorial(n-1), then factorial(n-2), …
 * until factorial(1).
 * 
 * So the number of recursive calls = n.
 * 
 * Each call just does O(1) work (multiplication + function overhead).
 * 
 * Time Complexity = O(n)
 * 
 * Space Complexity
 * 
 * The recursion goes as deep as n calls before returning.
 * 
 * Each recursive call is stored in the function call stack.
 * 
 * So, maximum stack depth = n.
 * 
 * Space Complexity = O(n)
 * 
 * Final Answer:
 * 
 * Time Complexity: O(n)
 * 
 * Space Complexity: O(n)
 */
public class FindFactorial {

	int factorial(int n) {
		if (n == 1) {
			return 1;
		}

		return n * factorial(n - 1);

	}

}
