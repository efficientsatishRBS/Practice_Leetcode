package com.practice.leetcode.arrays.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/description/ Leetcode
 * 11 Medium
 * 
 * Logic Explanation
 * 
 * Two-pointer approach:
 * 
 * Start with two pointers — left = 0, right = n - 1.
 * 
 * Compute the area: area = min(height[left], height[right]) * (right - left)
 * 
 * Update maxArea with the maximum of current and previous areas.
 * 
 * Move the pointer corresponding to the smaller height inward:
 * 
 * If height[left] < height[right], move left++
 * 
 * Else, move right--
 * 
 * Repeat until the pointers meet.
 * 
 * Why it works efficiently:
 * 
 * Moving the smaller height pointer is the only way to possibly increase the
 * area, because width always decreases.
 * 
 * The logic ensures all useful pairs are considered without redundant checks.
 * 
 * Complexity Analysis Type Complexity Explanation Time Complexity O(n) Each
 * element is visited at most once (one pass). Space Complexity O(1) Only a few
 * extra variables (left, right, maxArea, area).
 */
public class COntainerWithMostWater {

	public int maxArea(int[] height) {

		int n = height.length;

		int left = 0;
		int right = n - 1;

		int maxArea = 0;

		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);

			maxArea = Math.max(maxArea, area);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;

	}

}
