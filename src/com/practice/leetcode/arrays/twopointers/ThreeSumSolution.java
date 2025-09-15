package com.practice.leetcode.arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumSolution {
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int target = -nums[i];
			twoSum(nums, target, i + 1, nums.length - 1, result);

		}

		return result;

	}

	private void twoSum(int nums[], int target, int left, int right, List<List<Integer>> result) {
		while (left < right) {

			if (nums[left] + nums[right] > target) {
				right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				while (left < right && nums[left] == nums[left + 1]) {
					left++;
				}

				while (left < right && nums[right] == nums[right - 1]) {
					right--;
				}

				result.add(List.of(-target, nums[left], nums[right]));

				left++;
				right--;
			}
		}

	}

	public static void main(String[] args) {
		 ThreeSumSolution solution = new ThreeSumSolution();
		 System.out.println(solution.threeSum(new int[] {0,0,0}));
	}
}
