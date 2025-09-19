package com.practice.leetcode.arrays.prefixSum;

public class SubArrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		if (k <= 1) {
			return 0;
		}

		int product = 1;

		int subArrayCount = 0;

		int l = 0;
		int r = 0;
		for (r = 0; r < nums.length; r++) {
			product = product * nums[r];

			while (product >= k) {
				product /= nums[l];
				l++;
			}

			subArrayCount += r - l + 1;
		}

		return subArrayCount;

	}

}
