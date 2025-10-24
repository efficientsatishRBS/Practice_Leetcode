package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Leetcode 17 Medium TC - 4^n SC - O(n × kⁿ).
 * 
 * If digits = "23":
 * 
 * n = 2
 * 
 * k = 3
 * 
 * Total = 3² = 9 combinations
 * 
 * Each combination length = 2 → total characters stored = 18
 * 
 * If digits = "2345":
 * 
 * n = 4
 * 
 * k = ~3.5 → 3.5⁴ ≈ 150 combinations
 * 
 * Space grows exponentially.
 */
public class LetterCombinationOfPhoneNumber {

	List<String> result = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		solve(0, map, digits, new String());
		return result;
	}

	private void solve(int idx, Map<Character, String> map, String digits, String temp) {
		if (idx >= digits.length()) {
			result.add(new String(temp));
			return;
		}
		String str = map.get(digits.charAt(idx));
		for (int i = 0; i < str.length(); i++) {
			temp += str.charAt(i);
			solve(idx + 1, map, digits, temp);
			temp = temp.substring(0, temp.length() - 1);
		}
	}

}
