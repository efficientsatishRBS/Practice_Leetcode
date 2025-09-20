package com.practice.leetcode.arrays.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbers {
	
	public static void main(String[] args) {
		CountSmallerNumbers count = new CountSmallerNumbers();
		
		System.out.println(Arrays.toString(count.countSmallerNumbers(new int[] {5,2,6,1})));
	}

	public int[] countSmallerNumbers(int nums[]) {

		Pair arr[] = new Pair[nums.length];

		for (int i = 0; i < nums.length; i++) {
			arr[i] = new Pair(nums[i], i);
		}

		int counts[] = new int[nums.length];
		
		mergeSort(arr, 0, nums.length-1, counts);

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
