package com.practice.leetcode.arrays;

class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int l = 0;
        int r = nums.length-1;
        
        for (int i=nums.length-1; i>=0; i--) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                result[i] = nums[l] * nums[l];
                l++;
            } else {
                result[i] = nums[r] * nums[r];
                r--;
            }
        }
        return result;
        
    }
}
