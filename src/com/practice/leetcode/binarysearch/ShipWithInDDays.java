package com.practice.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 * Medium Leetcode 1011 
 * Time: O(n⋅log(sum(weights)−max(weights)))
 * Space: O(1)
 */
public class ShipWithInDDays {

	public int shipWithinDays(int[] weights, int days) {

		int minCap = 0;
		int maxCapacity = 0;

		for (int weight : weights) {
			minCap = Math.max(minCap, weight);
			maxCapacity += weight;

		}

		while (minCap < maxCapacity) {
			int mid = minCap + (maxCapacity - minCap) / 2;

			// find min no of days for mid capacity
			int daysRequired = minNoOfDaysForCapacity(weights, mid);

			if (daysRequired > days) {
				minCap = mid + 1;
			} else {
				maxCapacity = mid;
			}
		}

		return minCap;

	}

	private int minNoOfDaysForCapacity(int[] weights, int capacity) {
		int sum = 0;
		int days = 1;

		for (int weight : weights) {
			if (sum + weight > capacity) {
				sum = 0;
				days++;
			}
			sum += weight;
		}

		return days;
	}
}
