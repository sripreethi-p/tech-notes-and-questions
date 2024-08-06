package com.dsa.algorithms.problems.linkedlist;

import com.dsa.algorithms.domain.linkedlists.ListNode;

import java.util.List;

public class DoubleANumber {

    /*
    You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
    Return the head of the linked list after doubling it.
    1->8->9   ==>   3->7->8
     */

    /*
    NOTE : Solution : reverse the list -> double it -> reverse it back
     */

    public ListNode doubleIt(ListNode head) {
        ListNode reversedHead = reverse(head);
        ListNode current = reversedHead;
        int carry = 0;
        while (current != null) {
            int ans = current.val*2 + carry;
            if(ans >= 10) {
                carry = 1;
                ans = ans - 10;
            }
            else {
                carry = 0;
            }
            current.val = ans;
            if(current.next == null) {
                if(carry>0) {
                    current.next = new ListNode(carry);
                    return reverse(reversedHead);
                }
            }
            current = current.next;
        }

        return reverse(reversedHead);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
