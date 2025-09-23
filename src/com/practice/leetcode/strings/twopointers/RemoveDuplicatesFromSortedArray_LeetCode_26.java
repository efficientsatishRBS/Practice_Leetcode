package com.practice.leetcode.strings.twopointers;

public class RemoveDuplicatesFromSortedArray_LeetCode_26 {
	public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i=1;i<nums.length;i++) {

            if (nums[k-1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            } 
        }

        return k;
    }

}
