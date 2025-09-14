package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberIndexMap = new HashMap<>();
        int i = -1;
        for (int num : nums) {
            i++;
            int difference = target - num;
            if (numberIndexMap.containsKey(difference)) {
                return new int[] { numberIndexMap.get(difference), i };
            }
            numberIndexMap.put(num, i);
        }
        return new int[] {};
    }
}
