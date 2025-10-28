package com.practice.leetcode.arrays.otherquestions;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * Medium 238 TC - O(n) SC - O(1)
 * 
 * Logic Overview
 * 
 * Left Product Pass:
 * 
 * Create an array resultArray where resultArray[i] stores the product of all
 * elements to the left of index i.
 * 
 * For example, for [1, 2, 3, 4], after this step: resultArray = [1, 1, 2, 6]
 * 
 * Right Product Pass:
 * 
 * Use a variable rightProduct to store the cumulative product of elements to
 * the right of the current index.
 * 
 * Traverse from right to left, multiplying each resultArray[i] by rightProduct.
 * 
 * Update rightProduct after each step.
 * 
 * Result:
 * 
 * Each element in resultArray now represents the product of all elements in the
 * array except itself.
 * 
 * For [1,2,3,4], the final result is [24,12,8,6].
 * 
 * Complexity Analysis Type Complexity Explanation Time Complexity O(n) Two
 * single-pass loops through the array Space Complexity (extra) O(1) Uses only
 * one integer rightProduct (output array not counted)
 */
public class ProductofArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int resultArray[] = new int[n];
		resultArray[0] = 1;

		// Left product accumulation
		for (int i = 1; i < n; i++) {
			resultArray[i] = nums[i - 1] * resultArray[i - 1];
		}

		// Multiply with right product on the fly
		int rightProduct = 1;
		for (int i = n - 1; i >= 0; i--) {
			resultArray[i] = resultArray[i] * rightProduct;
			rightProduct *= nums[i];
		}

		return resultArray;
	}

}
