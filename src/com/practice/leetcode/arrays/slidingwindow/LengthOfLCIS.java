package com.practice.leetcode.arrays.slidingwindow;

public class LengthOfLCIS {

	public int findLengthOfLCIS(int[] nums) {
		int currentLength = 1;
		int maxLength = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				currentLength++;
				maxLength = Math.max(maxLength, currentLength);
			} else {
				currentLength = 1;
			}
		}
		return maxLength;

	}

}
