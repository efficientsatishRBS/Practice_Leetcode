package com.practice.leetcode.arrays.twopointers;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i=1;i<nums.length;i++) {

            if (nums[k-1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            } else {
                continue;
            }
        }

        return k;
    }

}
