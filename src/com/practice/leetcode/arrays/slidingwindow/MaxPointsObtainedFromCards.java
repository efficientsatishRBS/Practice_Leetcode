package com.practice.leetcode.arrays.slidingwindow;

public class MaxPointsObtainedFromCards {
	public int maxScore(int[] cardPoints, int k) {

		int totalSum = 0;

		for (int num : cardPoints) {
			totalSum += num;
		}

		int windowSize = cardPoints.length - k;
		int minimumSum = 0;
		for (int i = 0; i < windowSize; i++) {
			minimumSum += cardPoints[i];
		}

		int l = 0;
		int r = windowSize;
		int currentSum = minimumSum;
		while (r < cardPoints.length) {
			currentSum = currentSum - cardPoints[l] + cardPoints[r];
			minimumSum = Math.min(currentSum, minimumSum);
			r++;
			l++;
		}

		return totalSum - minimumSum;
	}

}
