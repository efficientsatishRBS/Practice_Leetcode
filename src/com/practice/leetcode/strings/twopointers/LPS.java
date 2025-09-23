package com.practice.leetcode.strings.twopointers;

class LPS {
	public String longestPalindrome(String s) {

		if (s.length() == 1) {
			return s;
		}

		String lps = "";
		for (int i = 1; i < s.length(); i++) {
			String oddLps = expandFromCentre(i, i, s);
			String evenLps = expandFromCentre(i - 1, i, s);

			if (oddLps.length() > lps.length()) {
				lps = oddLps;
			}

			if (evenLps.length() > lps.length())
				lps = evenLps;
		}

		return lps;

	}

	private String expandFromCentre(int l, int r, String s) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}
}
