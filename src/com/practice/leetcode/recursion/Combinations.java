package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/description/
 * Leetcode 77 Medium
 * TC - n!
 *     -----
 *     (n-k)!*k!
 */
public class Combinations {
	
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(1, n, k, new ArrayList<>());
        return result;    
    }

    public void solve(int start, int n, int k, List<Integer> temp) {
        if (k==0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (start>n) {
            return;
        }

        temp.add(start);
        solve(start+1, n , k-1, temp);
        temp.remove(temp.size()-1);
        solve(start+1, n, k, temp);
    }

}
