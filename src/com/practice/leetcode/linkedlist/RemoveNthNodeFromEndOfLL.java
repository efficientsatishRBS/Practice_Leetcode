package com.practice.leetcode.linkedlist;

import com.practice.leetcode.linkedlist.ReverseaLinkedList.ListNode;
/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Leetcode 19
 */
public class RemoveNthNodeFromEndOfLL {

	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			int llLength = findLengthOfLinkedList(head);

			if (llLength - n == 0) {
				return head.next;
			}

			int position = llLength - n;
			ListNode current = head;
			int counter = 1;
			while (current != null) {
				if (counter == position) {
					current.next = current.next.next;
					break;
				}
				counter++;
				current = current.next;
			}

			return head;
		}

		private int findLengthOfLinkedList(ListNode current) {
			int length = 0;

			while (current != null) {
				length++;
				current = current.next;
			}

			return length;
		}
	}

}
