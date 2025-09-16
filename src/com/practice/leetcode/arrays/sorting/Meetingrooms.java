package com.practice.leetcode.arrays.sorting;

import java.util.Arrays;

public class Meetingrooms {

	public boolean canAttendMeetings(int[][] intervals) {

		if (intervals.length == 0) {
			return true;
		}

		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		int[] previousInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			if (previousInterval[1] > intervals[i][0]) {
				return false;
			}
			previousInterval = intervals[i];
		}

		return true;

	}

}
