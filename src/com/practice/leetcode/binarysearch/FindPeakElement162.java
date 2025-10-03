package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/ Leetcode 162 medium
 * TC-O(logn) SC - o(1)
 * 
 * 
 * This solution finds a peak element in an array using binary search. A peak
 * element is one that is greater than its immediate neighbors.
 * 
 * Approach:
 * 
 * Use two pointers l and r to represent the current search range. At each step,
 * calculate the mid index. Compare nums[mid] with its neighbors (nums[mid-1]
 * and nums[mid+1]). If nums[mid] is greater than both neighbors, it is a peak →
 * return mid. If the right neighbor is greater, move search to the right (l =
 * mid + 1). Otherwise, move search to the left (r = mid - 1). Handle boundary
 * cases by treating out-of-bound neighbors as Integer.MIN_VALUE.
 * 
 * Key Insight:
 * 
 * At least one peak always exists in the array. By moving toward the side with
 * the larger neighbor, we ensure progress toward a peak.
 * 
 * Time Complexity: O(log n) → because binary search halves the search range at
 * each step. Space Complexity: O(1) → only a few variables are used.
 * 
 * Result: Efficiently returns the index of any peak element.
 */
public class FindPeakElement162 {

	public int findPeakElement(int[] nums) {

		int l = 0;
		int r = nums.length - 1;
		int result = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int rightNumber = (mid + 1) > r ? Integer.MIN_VALUE : nums[mid + 1];
			int leftNumber = (mid - 1) < 0 ? Integer.MIN_VALUE : nums[mid - 1];
			if (nums[mid] > rightNumber && nums[mid] > leftNumber) {
				result = mid;
				return mid;
			} else {
				if (nums[mid] < rightNumber) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}

		return result;

	}

}
