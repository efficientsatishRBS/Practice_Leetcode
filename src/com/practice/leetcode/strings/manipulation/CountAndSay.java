package com.practice.leetcode.strings.manipulation;

/**
 * https://leetcode.com/problems/count-and-say/description/ Leetcode 38
 * 
 * Time Complexity: O(Lₙ), where Lₙ is the length of the nth term. 
 * Space Complexity: O(Lₙ).
 * 
 */
public class CountAndSay {

	public String countAndSay(int n) {

		String result = "1";

		for (int i = 2; i <= n; i++) {
			int readPtr = 0;
			StringBuilder sb = new StringBuilder();
			while (readPtr < result.length()) {
				char currentChar = result.charAt(readPtr);

				int count = 0;
				while (readPtr < result.length() && currentChar == result.charAt(readPtr)) {
					count++;
					readPtr++;
				}

				sb.append(count).append(currentChar);
			}
			result = sb.toString();
		}

		return result;

	}

}
