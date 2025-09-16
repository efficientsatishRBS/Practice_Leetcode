package com.practice.leetcode.arrays.mergeintervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int[] previous = intervals[0];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (previous[1] <= intervals[i][0]) {
                //non-overlapping
                previous = intervals[i];
            } else {
                count++;
            }
        }

        return count;

    }

}
