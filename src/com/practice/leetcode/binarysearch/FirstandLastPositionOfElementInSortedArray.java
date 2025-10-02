package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Leetcode 34
 * Medium
 * O(logn)
 * O(1)
 */
public class FirstandLastPositionOfElementInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		return new int[] { getOccuranceOfTarget(nums, target, true, 0, nums.length - 1),
				getOccuranceOfTarget(nums, target, false, 0, nums.length - 1) };
	}

	private int getOccuranceOfTarget(int nums[], int target, boolean isFirstOccurance, int l, int r) {
		int targetIndex = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] < target) {
				l = mid + 1;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				targetIndex = mid;
				if (isFirstOccurance) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}

		return targetIndex;
	}

}
