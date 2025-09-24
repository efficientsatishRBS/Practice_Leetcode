package com.practice.leetcode.strings.slidingwindow;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * 
 * TC - O(n) SC - O(1)
 */
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {

		int i = 0;
		int j = 0;
		int maxWindow = Integer.MIN_VALUE;
		int maxFrequency = Integer.MIN_VALUE;
		int sArray[] = new int[26];

		while (j < s.length()) {
			char ch = s.charAt(j);

			sArray[ch - 'A']++;
			maxFrequency = Math.max(maxFrequency, sArray[ch - 'A']);
			int windowSize = j - i + 1;
			int noOfCharactersTobeReplaced = windowSize - maxFrequency;

			if (noOfCharactersTobeReplaced <= k) {
				maxWindow = Math.max(maxWindow, windowSize);
			} else {
				sArray[s.charAt(i) - 'A']--;
				i++;
			}
			j++;
		}
		return maxWindow;

	}

}
