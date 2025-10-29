package com.practice.leetcode.linkedlist;

import com.practice.leetcode.linkedlist.ReverseaLinkedList.Node;
/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * Medium 430
 */
public class FlattenADoublyLinkedList {

	public Node flatten(Node head) {

		Node current = head;

		while (current != null) {
			if (current.child != null) {
				Node next = current.next;
				current.next = flatten(current.child);
				current.next.prev = current;
				current.child = null;

				// find tail
				while (current.next != null) {
					current = current.next;
				}

				if (next != null) {
					current.next = next;
					current.next.prev = current;
				}
			}
			current = current.next;
		}

		return head;
	}

}
