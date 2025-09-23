package com.practice.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_LeetCode76 {
	public String minWindow(String s, String t) {

		if (t.length() > s.length()) {
			return "";
		}

		int minWindowSize = Integer.MAX_VALUE;
		int start_i = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : t.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int i = 0;
		int j = 0;
		int requiredCount = t.length();

		while (j < s.length()) {
			char ch = s.charAt(j);

			if (map.containsKey(ch) && map.get(ch) > 0) {
				requiredCount--;
			}
			map.put(ch, map.getOrDefault(ch, 0) - 1);
			// start shrinking the window
			while (requiredCount == 0) {
				int minimumWIndowTillNow = j - i + 1;
				if (minWindowSize > minimumWIndowTillNow) {
					minWindowSize = minimumWIndowTillNow;
					start_i = i;
				}

				ch = s.charAt(i);
				map.put(ch, map.get(ch) + 1);

				if (map.get(ch) > 0) {
					requiredCount++;
				}
				i++;
			}

			j++;
		}

		return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);

	}

}
