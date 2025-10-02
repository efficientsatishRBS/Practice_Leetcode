package com.practice.leetcode.binarysearch;

/**
 * 
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 * Leetcode 744 Easy How it works
 * 
 * Uses binary search:
 * 
 * If letters[mid] > target → potential answer found, store position = mid, and
 * search left (since there might be a smaller valid letter).
 * 
 * Otherwise (letters[mid] <= target) → move right (l = mid+1).
 * 
 * After the loop:
 * 
 * If no valid letter was found (position == -1), return the first letter
 * (wrap-around case).
 * 
 * Otherwise, return letters[position].
 * 
 * Complexity
 * 
 * Time Complexity: O(log n) — binary search.
 * 
 * Space Complexity: O(1) — only a few variables used.
 */
public class FindSmallestLatterGreaterThanTarget {

	public char nextGreatestLetter(char[] letters, char target) {

		int l = 0;
		int r = letters.length - 1;
		int position = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (letters[mid] > target) {
				position = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return position == -1 ? letters[0] : letters[position];

	}

}
