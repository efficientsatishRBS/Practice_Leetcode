package com.practice.leetcode.recursion;

/**
 * 
 * https://leetcode.com/problems/maximum-subarray/
 * Medium 
 * The Core Idea
 * 
 * We want the maximum sum of a contiguous subarray.
 * 
 * While traversing, we have two choices at each element:
 * 
 * Extend the current subarray (keep adding the current element).
 * 
 * Start a new subarray from this element.
 * 
 * Kadane’s Algorithm helps us decide which option is better in constant time.
 * 
 * Why reset when currentSum <= 0?
 * 
 * If currentSum becomes negative, then carrying it forward will decrease the
 * sum of any future subarray.
 * 
 * Example:
 * 
 * Suppose currentSum = -2 and the next element is 5.
 * 
 * If we keep -2 + 5 = 3, but starting fresh from 5 gives 5.
 * 
 * Clearly, starting fresh is better.
 * 
 * That’s why we reset currentSum to 0 whenever it drops below 0.
 * 
 * Time Complexity: O(n) (single pass through array).
 * 
 * Space Complexity: O(1) (constant extra variables only).
 */
public class MaxSubArray {

	public int maxSubArray(int[] nums) {

		int currentSum = 0;

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];

			maxSum = Math.max(maxSum, currentSum);
			if (currentSum <= 0) {
				currentSum = 0;
			}

		}

		return maxSum;
	}
}
