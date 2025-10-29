package com.practice.leetcode.heap;

import java.util.PriorityQueue;
/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Leetcode 215 Medium
 */
public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		return queue.poll();
	}
}
