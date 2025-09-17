package com.practice.leetcode.arrays.sorting;

import java.util.Arrays;

public class WiggleSort2 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;

		int[] temp = new int[n];

		int mid = 0 + (n - 1) / 2; // ceil(n/2)
		int left = mid; // end of first half
		int right = n - 1; // end of second half

		// Fill alternately
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				temp[i] = nums[left--]; // (in reverse)
			} else {
				temp[i] = nums[right--]; // (in reverse)
			}
		}

		// Copy back to nums
		for (int i = 0; i < n; i++) {
			nums[i] = temp[i];
		}
	}

}
