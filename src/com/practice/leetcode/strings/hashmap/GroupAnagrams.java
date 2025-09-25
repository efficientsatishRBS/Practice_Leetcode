package com.practice.leetcode.strings.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/ Leetcode 49
 * 
 * Time O(n * m log m) Space O(n * m)
 */
class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedKey = new String(charArray);
			map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);

		}

		return new ArrayList<>(map.values());

	}
}
