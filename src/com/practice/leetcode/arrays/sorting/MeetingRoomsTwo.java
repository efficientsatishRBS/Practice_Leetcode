package com.practice.leetcode.arrays.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {

	public int minMeetingRooms(int[][] intervals) {
		PriorityQueue<Integer> queueByEndTime = new PriorityQueue<>();

		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		for (int interval[] : intervals) {
			if (!queueByEndTime.isEmpty() && queueByEndTime.peek() <= interval[0]) {
				queueByEndTime.poll();
			}
			queueByEndTime.add(interval[1]);
		}

		return queueByEndTime.size();
	}

}
