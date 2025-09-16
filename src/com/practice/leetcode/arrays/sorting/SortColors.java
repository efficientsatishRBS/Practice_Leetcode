package com.practice.leetcode.arrays.sorting;

import java.util.Arrays;

public class SortColors {

	public void sortColors(int[] nums) {

		int[] countArray = new int[3];

		for (int num : nums) {
			countArray[num]++;
		}
		int color = 0;
		int i = 0;
		while (i < nums.length) {
			int count = countArray[color];

			while (count > 0) {
				nums[i++] = color;
				count--;
			}

			color++;
		}

	}

	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
		int nums[] = new int[] { 2, 0, 2, 1, 1, 0 };
		sortColors.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}
