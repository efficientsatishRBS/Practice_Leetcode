package com.practice.leetcode.arrays.otherquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		int[][] arrays = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };

		System.out.println(mergeKSortedArrays(arrays));
	}

	private static List<Integer> mergeKSortedArrays(int[][] arrays) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.value - b.value);

		for (int i = 0; i < arrays.length; i++) {
			queue.add(new Node(arrays[i][0], i, 0));
		}

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			result.add(current.value);

			int nextIndex = current.elementIndex + 1;

			if (nextIndex < arrays[current.arrayIndex].length) {
				queue.add(new Node(arrays[current.arrayIndex][nextIndex], current.arrayIndex, nextIndex));

			}

		}

		return result;
	}

	private static class Node {
		private int value;
		private int arrayIndex;
		private int elementIndex;

		public Node(int value, int arrayIndex, int elementIndex) {
			this.value = value;
			this.arrayIndex = arrayIndex;
			this.elementIndex = elementIndex;
		}

	}

}
