package com.dsa.algorithms.service.linkedlist;

import com.dsa.algorithms.domain.linkedlists.ListNode;

public class LinkedListAlgorithms {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(1);
        ListNode a = l1;
        ListNode b = l2;
        ListNode s = sumNode;

        int carry = 0;

        while (a!=null && b!=null) {
            int sum = a.val+b.val+carry;
            if(sum>=10) {
                carry=1;
                sum = sum-10;
            }
            else {
                carry = 0;
            }
            s.val = sum;
            s.next = new ListNode();
            a = a.next;
            b = b.next;
            s = s.next;
        }

        if (a!=null) {
            s = a;

        }

        if (b!= null) {
            s = b;
        }


        return sumNode;
    }
}
