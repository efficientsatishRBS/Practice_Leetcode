package com.practice.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * Leetcode 347 Medium
 */
public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Node> numFreqMap = new HashMap<>();
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

		for (int i = 0; i < nums.length; i++) {
			Node node = numFreqMap.computeIfAbsent(nums[i], key -> new Node(key, 0));
			node.frequency += 1;
		}

		for (Node node : numFreqMap.values()) {
			pq.add(node);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		int result[] = new int[k];
		int i = 0;
		while (!pq.isEmpty()) {
			result[i++] = pq.poll().value;
		}

		return result;

	}

	private static class Node {
		private int value;
		private int frequency;

		public Node(int value, int frequency) {
			this.value = value;
			this.frequency = frequency;
		}

	}

}
