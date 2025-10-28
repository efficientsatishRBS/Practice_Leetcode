package com.practice.leetcode.linkedlist;

import com.practice.leetcode.linkedlist.ReverseaLinkedList.ListNode;
/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Leetcode 21 Easy
 */
public class MergeTwoSortedLinkedList {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode current1 = list1;
        ListNode current2 = list2;

        while (current1 != null && current2!=null) {
            if (current1.val < current2.val) {
                dummy.next = new ListNode(current1.val);
                dummy = dummy.next;
                current1 = current1.next;
            } else {
                dummy.next = new ListNode(current2.val);
                dummy = dummy.next;
                current2 = current2.next;
            }
        }

        if (current1 != null) {
            dummy.next = current1;
        }

        if (current2!= null) {
            dummy.next = current2;
        }

        return head.next;
    }

}
