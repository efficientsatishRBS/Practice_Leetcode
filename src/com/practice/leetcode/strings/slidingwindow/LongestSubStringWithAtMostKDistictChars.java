package com.practice.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 * 
 * Medium
 * 
 * Time: O(n)

   Space: O(k)
 */

public class LongestSubStringWithAtMostKDistictChars {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0 || s.length() == 0) {
			return 0;
		}
		int maxLength = 0;

		int i = 0;
		int j = 0;

		Map<Character, Integer> map = new HashMap<>();

		while (j < s.length()) {

			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() <= k) {
				int lengthTillNow = j - i + 1;
				maxLength = Math.max(maxLength, lengthTillNow);
			} else {
				while (map.size() > k) {
					ch = s.charAt(i);
					map.put(ch, map.get(ch) - 1);
					if (map.get(ch) == 0) {
						map.remove(ch);
					}
					i++;
				}
			}

			j++;
		}
		return maxLength;
	}

}
