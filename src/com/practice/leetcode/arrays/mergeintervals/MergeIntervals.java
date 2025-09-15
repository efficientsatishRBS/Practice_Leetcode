package com.practice.leetcode.arrays.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		List<int[]> merged = new ArrayList<>();
		int[] previousOne = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			int[] currentOne = intervals[i];

			if (previousOne[1] >= currentOne[0]) {
				previousOne[1] = Math.max(previousOne[1], currentOne[1]);
			} else {
				merged.add(previousOne);
				previousOne = currentOne;
			}
		}

		merged.add(previousOne);
		return merged.toArray(new int[merged.size()][]);

	}

}
