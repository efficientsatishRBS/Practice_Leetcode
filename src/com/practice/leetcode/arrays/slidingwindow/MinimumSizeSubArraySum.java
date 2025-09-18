package com.practice.leetcode.arrays.slidingwindow;

public class MinimumSizeSubArraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int totalSum = 0;
		int minLength = Integer.MAX_VALUE;
		int l = 0;
		int r = 0;

		for (r = 0; r < nums.length; r++) {
			totalSum += nums[r];
			if (totalSum >= target) {
				while (totalSum >= target) {
					int length = r - l + 1;
					minLength = Math.min(length, minLength);
					totalSum -= nums[l++];
				}
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;

	}

}
