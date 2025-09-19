package com.practice.leetcode.arrays.prefixSum;

public class MaximumSizeSubArraySumEqualsK {

	public static int maximumSizeSubArraySumEqualsK(int nums[], int k) {

		int maxLength = 0;
		int sum = 0;

		int l = 0;
		int r = 0;

		for (r = 0; r < nums.length; r++) {
			sum = sum + nums[r];

			while (sum > k) {
				sum -= nums[l++];
			}

			if (sum == k) {
				maxLength = Math.max(maxLength, r - l + 1);
			}

		}

		return maxLength;

	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4,5, 1,1,1,1,1};
		System.out.println(MaximumSizeSubArraySumEqualsK.maximumSizeSubArraySumEqualsK(arr, 5));
		
	}

}
