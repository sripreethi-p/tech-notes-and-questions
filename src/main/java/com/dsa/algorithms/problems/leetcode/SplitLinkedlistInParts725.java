package com.dsa.algorithms.problems.leetcode;

public class SplitLinkedlistInParts725 {
    /*
    Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.
     */

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = getTotalNumberOfNodes(head);
        int size = n/k;
        int nodesWithSizePlus1 = n%k;
        ListNode[] result = new ListNode[k];

        ListNode current = head;

        for (int i =1; i<=nodesWithSizePlus1; i++) {
            result[i-1] = current;
            for (int j = 1; j<size+1; j++) {
                current = current.next;
            }
            ListNode next = current.next;
            current.next = null;
            current = next;
        }

        for (int i =1; i<=(k-nodesWithSizePlus1); i++) {
            result[nodesWithSizePlus1+i-1] = current;
            for (int j = 1; j<size; j++) {
                current = current.next;
            }
            if (current!=null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }

        return result;

    }

    private int getTotalNumberOfNodes(ListNode head) {
        int count = 0;
        ListNode current = head;
        while(current!=null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
