package com.practice.leetcode.arrays.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program Summary – CountSmallerNumbersPractice
 * 
 * This program solves the problem “Count of Smaller Numbers After Self”
 * (similar to LeetCode #315).
 * 
 * Goal: For each element in an array, count how many numbers to its right are
 * smaller than it.
 * 
 * Approach Used:
 * 
 * It uses a modified Merge Sort technique to count smaller elements while
 * sorting.
 * 
 * Instead of brute force O(n²) approach, merge sort reduces it to O(n log n).
 * 
 * How It Works:
 * 
 * Each number is wrapped in a Pair (value + original index).
 * 
 * During merge sort:
 * 
 * When merging two sorted halves, if a number from the right half is smaller
 * than a number from the left half, a counter (rightCount) is incremented.
 * 
 * For each left-side number placed into the merged array, the accumulated
 * rightCount is added to that number’s count.
 * 
 * The result is an array where each index stores the count of smaller numbers
 * to the right of that element.
 * 
 * Example Execution: Input: [5, 2, 6, 1] Output: [2, 1, 1, 0]
 * 
 * 5 → two smaller numbers to the right (2,1)
 * 
 * 2 → one smaller number (1)
 * 
 * 6 → one smaller number (1)
 * 
 * 1 → no smaller numbers
 * 
 * Key Classes & Methods:
 * 
 * Pair: Stores (value, index) to track original positions.
 * 
 * mergeSort(): Standard recursive merge sort, but customized to count smaller
 * numbers.
 * 
 * merge(): Performs merge, updating count[index] using rightCount.
 * 
 * Time Complexity: O(n log n)
 * 
 * Space Complexity: O(n) (for temporary arrays during merging).
 * 
 * In short: This program counts, for each element in an array, how many
 * smaller elements appear to its right using a divide-and-conquer merge sort
 * counting technique.
 * 
 * Time Complexity

The algorithm is based on merge sort, which divides the array and merges it back.

Each recursive level of merge sort processes n elements, and there are log n levels.

So, total time = O(n log n).

Extra work during merging (count updates) is constant per element, so it does not increase complexity.

Final Time Complexity: O(n log n)

Space Complexity

The program creates:

Pair[] pArr → size n.

count[] → size n.

Temporary List<Pair> temp during each merge → up to size n.

Merge sort recursion depth = O(log n).

So, total extra space = O(n) (arrays + temporary list) + O(log n) (recursion stack).

Final Space Complexity: O(n)
 */
public class CountSmallerNumbers {

	public static void main(String[] args) {
		CountSmallerNumbers count = new CountSmallerNumbers();

		System.out.println(Arrays.toString(count.countSmallerNumbers(new int[] { 5, 2, 6, 1 })));
	}

	public int[] countSmallerNumbers(int nums[]) {

		Pair arr[] = new Pair[nums.length];

		for (int i = 0; i < nums.length; i++) {
			arr[i] = new Pair(nums[i], i);
		}

		int counts[] = new int[nums.length];

		mergeSort(arr, 0, nums.length - 1, counts);

		return counts;

	}

	private void mergeSort(Pair[] arr, int left, int right, int counts[]) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;

		mergeSort(arr, left, mid, counts);
		mergeSort(arr, mid + 1, right, counts);
		merge(arr, left, mid, right, counts);
	}

	private void merge(Pair arr[], int left, int mid, int right, int[] counts) {
		List<Pair> temp = new ArrayList<>();

		int rightCount = 0;
		int k = left;
		int i = left;
		int j = mid + 1;

		while (i <= mid && j <= right) {
			if (arr[j].value < arr[i].value) {
				rightCount++;
				temp.add(arr[j]);
				j++;
			} else {
				temp.add(arr[i]);
				counts[arr[i].index] += rightCount;
				i++;
			}
		}

		while (i <= mid) {
			temp.add(arr[i]);
			counts[arr[i].index] += rightCount;
			i++;
		}

		while (j <= right) {
			temp.add(arr[j]);
			j++;
		}

		for (k = left; k <= right; k++) {
			arr[k] = temp.get(k - left);
		}

	}

}

class Pair {
	int value;
	int index;

	public Pair(int value, int index) {
		this.value = value;
		this.index = index;
	}
}
