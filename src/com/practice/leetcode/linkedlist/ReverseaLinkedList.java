package com.practice.leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Leetcode 206 Easy
 */
public class ReverseaLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode previous = null;

		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public static class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	}

}
