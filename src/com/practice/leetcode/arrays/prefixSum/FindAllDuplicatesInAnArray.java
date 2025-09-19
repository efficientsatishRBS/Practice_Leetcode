package com.practice.leetcode.arrays.prefixSum;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> list = new ArrayList<>();

		if (nums.length == 1) {
			return list;
		}

		for (int num : nums) {
			int idx = Math.abs(num) - 1;
			if (nums[idx] < 0) {
				list.add(Math.abs(num));
			} else {
				nums[idx] = -nums[idx];
			}
		}

		return list;

	}

}
