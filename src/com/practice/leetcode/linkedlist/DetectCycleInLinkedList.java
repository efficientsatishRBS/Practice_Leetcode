package com.practice.leetcode.linkedlist;

import com.practice.leetcode.linkedlist.ReverseaLinkedList.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 * Leetcode 141 Easy
 */
public class DetectCycleInLinkedList {
	
	public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (slowPtr!=null && fastPtr!=null && fastPtr.next!=null) {
           slowPtr = slowPtr.next;
           fastPtr = fastPtr.next.next;


           if (slowPtr == fastPtr) {
               return true;
           }
        }

        return false;
   }

}
