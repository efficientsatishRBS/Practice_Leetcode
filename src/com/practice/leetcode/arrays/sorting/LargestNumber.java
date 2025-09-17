package com.practice.leetcode.arrays.sorting;

import java.util.Arrays;

public class LargestNumber {
	public String largestNumber(int[] nums) {

		String array[] = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			array[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(array, (o2, o1) -> (o1 + o2).compareTo(o2 + o1));
		if (array[0].equals("0")) {
			return "0";
		}

		StringBuilder builder = new StringBuilder();

		for (String largestvalue : array) {
			builder.append(largestvalue);
		}

		return builder.toString();

	}

}
