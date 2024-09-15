package com.dsa.algorithms.problems.leetcode;

public class InsertGreatestCommonDivisorsInLinkedlist {
  /*
  Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
   */


  public ListNode insertGreatestCommonDivisors(ListNode head) {
    ListNode current = head;
    while(current.next!=null) {
      ListNode next = current.next;
        int gcd = gcd(current.val, next.val);
        ListNode newNode = new ListNode(gcd);
        current.next = newNode;
        newNode.next = next;
        current = next;
    }
    return head;
  }

  private int gcd(Integer a, Integer b) {
    while(b!=0) {
      int temp = b;
        b = a%b;
        a = temp;
    }
    return a;
  }

}