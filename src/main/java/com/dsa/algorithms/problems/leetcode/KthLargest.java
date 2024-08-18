package com.dsa.algorithms.problems.leetcode;

import java.util.*;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:
    Input
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    Output
        [null, 4, 5, 5, 8, 8]

    Explanation
        KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
 */
public class KthLargest {
    int k;
    List<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        List<Integer> newList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        newList.sort(null);
        this.list = newList;
    }

    public int add(int val) {
        int index = list.indexOf(val);
        list.add(index, val);
        return list.get(list.size()-k);
    }

    private int getIndex(int val) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == val) {
                return mid;
            }
            if (list.get(mid) < val) {
                left = mid + 1;
            }
            if (list.get(mid) > val) {
                right = mid - 1;
            }
        }
        return left;
    }
}
