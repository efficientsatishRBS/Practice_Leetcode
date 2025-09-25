package com.practice.leetcode.strings.hashmap;

import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode.com/problems/valid-anagram/description/
 * Leetcode 242
 * Easy
 * 
 * Time and space complexity
 * First Approach
 * Complexity Analysis

Time Complexity

Loop over s → O(n)

Loop over t → O(n)

Final check of count array (size 26) → O(26) = O(1)

Total = O(n)

Space Complexity

One fixed-size array of 26 → O(1)

No extra memory grows with input

For Second approach
HashMap-based approach (Unicode-safe)

Time Complexity: O(n)

Space Complexity: O(u) → O(n) in the worst case
   
 * 
 * 
 */
public class ValidAnagram {
	public boolean isAnagram1(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a']--;
		}

		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}

		return true;

	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> countMap = new HashMap<>();

		// Count characters in s
		for (char c : s.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}

		// Subtract characters in t
		for (char c : t.toCharArray()) {
			if (!countMap.containsKey(c)) {
				return false; // extra char in t
			}
			countMap.put(c, countMap.get(c) - 1);
			if (countMap.get(c) == 0) {
				countMap.remove(c);
			}
		}

		// If map is empty, they are anagrams
		return countMap.isEmpty();
	}
}
