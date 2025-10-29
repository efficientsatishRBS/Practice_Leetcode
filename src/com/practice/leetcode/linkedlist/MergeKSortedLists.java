package com.practice.leetcode.linkedlist;

import com.practice.leetcode.linkedlist.ReverseaLinkedList.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/ Leetcode 23
 * Hard
 */
public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		return partitionAndMerge(lists, 0, lists.length - 1);
	}

	public ListNode partitionAndMerge(ListNode[] lists, int l, int r) {
		if (l == r) {
			return lists[l];
		}

		int mid = l + (r - l) / 2;

		ListNode L1 = partitionAndMerge(lists, l, mid);
		ListNode L2 = partitionAndMerge(lists, mid + 1, r);
		return mergeTwoLists(L1, L2);
	}

	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		if (list1.val <= list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list2.next, list1);
			return list2;
		}
	}

}
