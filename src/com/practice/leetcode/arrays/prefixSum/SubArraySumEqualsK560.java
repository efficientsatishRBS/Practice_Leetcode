package com.practice.leetcode.arrays.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK560 {
	public int subarraySum(int[] nums, int k) {
		int cummSum = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			cummSum += nums[i];

			if (map.containsKey(cummSum - k)) {
				count += map.get(cummSum - k);
			}

			map.put(cummSum, map.getOrDefault(cummSum, 0) + 1);
			// 4------13 -13. 13. 22
			// it shows we can have two subarrays both ending at 13
		}

		return count;
	}

}
