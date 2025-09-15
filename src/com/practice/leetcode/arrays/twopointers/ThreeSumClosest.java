package com.practice.leetcode.arrays.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {

		int closestSum = 100000;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];

				if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
					closestSum = sum;
				}

				if (sum < target) {
					l++;
				} else if (sum > target) {
					r--;
				} else if (sum == target) {
					return sum;
				}
			}
		}

		return closestSum;

	}

}
