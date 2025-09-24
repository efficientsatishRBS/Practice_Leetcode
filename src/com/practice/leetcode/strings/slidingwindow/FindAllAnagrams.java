package com.practice.leetcode.strings.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * Medium
 * 
 * Final Complexity
 * 
 * Time: O(|s| + |p|)
 * 
 * Space: O(1) auxiliary
 */
public class FindAllAnagrams {

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> list = new ArrayList<>();

		int pArray[] = new int[26];
		for (char ch : p.toCharArray()) {
			pArray[ch - 'a']++;
		}

		int l = 0;
		int r = 0;

		while (r < s.length()) {
			char ch = s.charAt(r);

			pArray[ch - 'a']--;

			int windowLength = r - l + 1;
			// means we have traversed a pLength size window
			if (windowLength == p.length()) {
				boolean allZero = true;
				for (int val : pArray) {
					if (val != 0) {
						allZero = false;
						break;
					}
				}
				if (allZero) {
					list.add(l);
				}
				ch = s.charAt(l);
				pArray[ch - 'a']++;
				l++;
			}

			r++;
		}

		return list;

	}

}
