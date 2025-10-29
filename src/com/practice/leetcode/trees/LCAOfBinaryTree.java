package com.practice.leetcode.trees;

import com.practice.leetcode.trees.BinaryTreeInorderTraversal.TreeNode;
/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * Leetcode 236 Medium
 */
public class LCAOfBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);

		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		if (left != null) {
			return left;
		} else {
			return right;
		}

	}

}
