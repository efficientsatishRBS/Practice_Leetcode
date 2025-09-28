package com.practice.leetcode.strings.manipulation;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/ Leetcode 394
 * MEDIUM
 * 
 * Time Complexity = O(n + m)

n = input length (reading string)

m = output length (building expanded string)

Space Complexity = O(m + d)

m = space for final decoded string

d = maximum nesting depth of brackets ([ … ])
 * 
 */
class DecodeStrings {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build full number (handles multi-digit)
                num = num * 10 + (c - '0');
            } 
            else if (c == '[') {
                // Push current number & string, reset for new block
                numStack.push(num);
                strStack.push(current);
                num = 0;
                current = new StringBuilder();
            } 
            else if (c == ']') {
                // Pop and repeat
                int k = numStack.pop();
                StringBuilder decoded = strStack.pop();
                for (int i = 0; i < k; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } 
            else {
                // Just a letter
                current.append(c);
            }
        }

        return current.toString();
    }
    
    public static void main(String[] args) {
		DecodeStrings solution = new DecodeStrings();
		System.out.println(solution.decodeString("3[a2[b]2[z]]"));
	}
}

