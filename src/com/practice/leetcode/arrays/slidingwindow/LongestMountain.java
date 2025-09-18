package com.practice.leetcode.arrays.slidingwindow;

public class LongestMountain {
	public int longestMountain(int[] arr) {

		if (arr.length < 3) {
			return 0;
		}

		int longestMountain = 0;

		// find peak element. it cannot be at 0 and n-1 index
		// So start loop from 1 and go upto n-2

		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
				// found peak elelment now traverse in left and right to find the mountain
				// length

				int left = i;
				int right = i;
				while (left > 0 && arr[left] > arr[left - 1]) {
					left--;
				}

				while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
					right++;
				}

				int mountainLength = right - left + 1;
				longestMountain = Math.max(longestMountain, mountainLength);
				i = right;
			}

		}

		return longestMountain;

	}

}
