package com.practice.leetcode.strings.hashmap;

/**
 * https://leetcode.com/problems/string-compression/description/ 
 * Leetcode 443
 * Medium
 * Time Complexity: O(n)

   Space Complexity: O(log n) (due to temporary string for count)
 * 
 */
public class StringCompression {

	public int compress(char[] chars) {

		int readPtr = 0;
		int writePtr = 0;

		while (readPtr < chars.length) {
			char currentChar = chars[readPtr];

			int count = 0;
			while (readPtr < chars.length && currentChar == chars[readPtr]) {
				count++;
				readPtr++;
			}

			chars[writePtr++] = currentChar;
			if (count > 1) {
				String value = Integer.toString(count);
				for (char tempChar : value.toCharArray()) {
					chars[writePtr++] = tempChar;
				}
			}

		}

		return writePtr;
	}

}
