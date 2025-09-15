package com.practice.leetcode.arrays.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> list = new ArrayList<>();
		// here idea is to check if new interval comes after current interval or before
		// if not after or before then the intervals must be overlapping
		int i = 0;
		for (int[] interval : intervals) {
			if (interval[1] < newInterval[0]) {
				list.add(interval);
			} else if (interval[0] > newInterval[1]) {
				break;
			} else {
				// merge
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
			}
			i++;
		}

		list.add(newInterval);
		while (i < intervals.length) {
			list.add(intervals[i++]);
		}

		return list.toArray(new int[list.size()][]);

	}

}
