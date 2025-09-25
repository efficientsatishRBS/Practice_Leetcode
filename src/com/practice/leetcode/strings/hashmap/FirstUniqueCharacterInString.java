package com.practice.leetcode.strings.hashmap;
/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * Leetcode 387
 * 
 * T and S complexity
 * O(n)
 * O(1)
 */
public class FirstUniqueCharacterInString {
	
	public int firstUniqChar(String s) {

        int freqArray[] = new int[26];

        for (int i=0;i<s.length();i++) {
            freqArray[s.charAt(i) - 'a']++;
        }

        for (int i=0;i<s.length();i++) {
            if (freqArray[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        
        return -1;
        
    }

}
