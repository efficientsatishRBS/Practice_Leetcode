package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * Medium Leetcode 852
 * 
 * TC - O(logn) SC - O(1)
 */
public class PeakIndexInMountainArray {

	public int peakIndexInMountainArray(int[] arr) {

		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;

			if (arr[mid] < arr[mid + 1]) {
				l = mid + 1;
			} else {
				// arr[mid] > arr[mid+1]
				r = mid;
			}
		}

		return l;

	}

}
