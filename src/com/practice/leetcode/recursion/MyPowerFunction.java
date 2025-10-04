package com.practice.leetcode.recursion;

/**
 * https://leetcode.com/problems/powx-n/description/ Leetcode 50 Medium TC and
 * SC- O(logn)
 * 
 * Problem
 * 
 * Compute 𝑥 𝑛 x n efficiently, handling:
 * 
 * Positive and negative powers
 * 
 * Large powers without overflow
 * 
 * 🔹 Approach
 * 
 * Base Cases:
 * 
 * 𝑛 = 0 ⇒ 1 n=0⇒1
 * 
 * 𝑛 = 1 ⇒ 𝑥 n=1⇒x
 * 
 * Handle negative powers:
 * 
 * 𝑥 − 𝑛 = ( 1 / 𝑥 ) 𝑛 x −n =(1/x) n
 * 
 * Exponentiation by squaring:
 * 
 * If 𝑛 n is even → 𝑥 𝑛 = ( 𝑥 2 ) 𝑛 / 2 x n =(x 2 ) n/2
 * 
 * If 𝑛 n is odd → 𝑥 𝑛 = 𝑥 ⋅ ( 𝑥 2 ) ( 𝑛 − 1 ) / 2 x n =x⋅(x 2 ) (n−1)/2
 * 
 * Recursive calls halve n at each step, reducing the number of multiplications.
 * 
 * 🔹 Complexity
 * 
 * Time Complexity: O(log n) → each recursive call halves n.
 * 
 * Space Complexity: O(log n) → recursion stack depth is proportional to log n.
 * 
 * Can be reduced to O(1) with iterative approach.
 * 
 * 🔹 Advantages
 * 
 * Much faster than naive O(n) multiplication.
 * 
 * Handles negative powers safely.
 * 
 * Avoids integer overflow by using long n.
 * 
 */
public class MyPowerFunction {

	public double myPow(double x, int n) {

		return solve(x, n);
	}

	private double solve(double x, long n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x * 1;
		}

		if (n < 0) {
			return solve(1 / x, -n);
		} else if (n % 2 == 0) {
			return solve(x * x, n / 2);
		} else if (n % 2 != 0) {
			return x * solve(x * x, (n - 1) / 2);
		}
		return -1;
	}

}
