package com.practice.leetcode.binarysearch;


/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 * Leetcode 643
 * Easy
 * 
 * TC-O(n)
 * SC - 0(1)
 */
public class MaximumAvgSubArray1 {
	
	public double findMaxAverage(int[] nums, int k) {

        int kWindowSum = 0;
        
        for (int i=0;i<k;i++) {
            kWindowSum+= nums[i];
        }

        int maxSum = kWindowSum;

        int l =0;
        int r = k;
        while (r<nums.length) {
             kWindowSum = kWindowSum-nums[l]+nums[r];
             maxSum = Math.max(maxSum, kWindowSum);
             l++;
             r++;
        }

        return (double) maxSum/k;
        
    }

}
