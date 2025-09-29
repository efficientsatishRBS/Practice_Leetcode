package com.practice.leetcode.binarysearch;

/**
 * 
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 * Leetcode 744
 * Easy
 * How it works
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

}
