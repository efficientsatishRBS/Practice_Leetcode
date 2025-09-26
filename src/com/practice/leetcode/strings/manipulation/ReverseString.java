package com.practice.leetcode.strings.manipulation;

/**
 * https://leetcode.com/problems/reverse-string/description/ Leetcode 344 Easy
 * 
 * Time Complexity
 * The loop runs until left < right.
 * On each iteration, one swap occurs, and both pointers move closer.
 * The number of iterations is about n/2, where n = s.length.
 * So, time complexity = O(n).
 * 
 * Space Complexity
 * Only using a few variables: left, right, and temp.
 * No extra data structures proportional to input size.
 * So, space complexity = O(1) (in-place reversal).
 */
public class ReverseString {

	public void reverseString(char[] s) {

		int left = 0;
		int right = s.length - 1;

		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}

}
