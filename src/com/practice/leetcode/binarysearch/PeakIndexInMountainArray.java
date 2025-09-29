package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * Medium Leetcode 852
 * 
 * TC - O(logn) SC - O(1)
 * 
 * Fast idea (binary search — O(log n))
 * 
 * Use the fact that:
 * 
 * if arr[mid] < arr[mid+1] you are on the increasing slope → peak is to the
 * right
 * 
 * otherwise (arr[mid] > arr[mid+1]) you are on the decreasing slope (or at
 * peak) → peak is at mid or to the left
 * 
 * So repeatedly shrink the search interval until l == r which will be the peak
 * index.
 * 
 * 
 * 
 * 
 * 
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
