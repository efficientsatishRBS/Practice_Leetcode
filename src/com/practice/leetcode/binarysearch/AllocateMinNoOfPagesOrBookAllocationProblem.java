package com.practice.leetcode.binarysearch;
/**
 * https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 * Time: O(n⋅log(sum(pages)−max(pages)))
 * Space: O(1)
 */
public class AllocateMinNoOfPagesOrBookAllocationProblem {

	public int findPages(int[] arr, int k) {

		if (k > arr.length) {
			return -1;
		}

		int minPages = 0;
		int maxPages = 0;

		for (int pages : arr) {
			minPages = Math.max(minPages, pages);
			maxPages += pages;
		}

		while (minPages < maxPages) {

			int mid = minPages + (maxPages - minPages) / 2;

			if (isPossible(arr, k, mid)) {
				maxPages = mid;
			} else {
				minPages = mid + 1;
			}
		}

		return minPages;

	}

	private boolean isPossible(int[] arr, int students, int limit) {
		int studentCount = 1;
		int pagesCount = 0;

		for (int pages : arr) {
			if (pagesCount + pages > limit) {
				pagesCount = 0;
				studentCount++;
			}
			pagesCount += pages;
		}

		return studentCount <= students;
	}

}
