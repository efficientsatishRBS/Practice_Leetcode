package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	List<Integer> list = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		solve(root);
		return list;
	}

	private void solve(TreeNode root) {
		if (root == null) {
			return;
		}
		solve(root.left);
		list.add(root.val);
		solve(root.right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
