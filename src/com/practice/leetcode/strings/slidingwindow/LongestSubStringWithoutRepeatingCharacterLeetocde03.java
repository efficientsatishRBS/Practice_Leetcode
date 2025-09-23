package com.practice.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacterLeetocde03 {

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();

		int longestLength = Integer.MIN_VALUE;

		int i = 0;
		int j = 0;

		while (j < s.length()) {
			char ch = s.charAt(j);
			if (!map.containsKey(ch) || map.get(ch) < i) {
				map.put(ch, j);
				longestLength = Math.max(j - i + 1, longestLength);
			} else {
				i = map.get(ch) + 1;
				map.put(ch, j);
			}
			j++;
		}
		return longestLength;
	}

}
