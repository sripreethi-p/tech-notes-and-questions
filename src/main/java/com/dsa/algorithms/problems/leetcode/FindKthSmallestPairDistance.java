package com.dsa.algorithms.problems.leetcode;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    /*
    The distance of a pair of integers a and b is defined as the absolute difference between a and b.
    Given an integer array nums and an integer k,
    return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
     */

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int res = Math.abs(nums[0] - nums[2]);
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(nums[i] - getKthClosest(nums, k, n, i));
            if (diff < res) {
                res = diff;
            }
        }

        return res;

    }

    private int getKthClosest(int[] nums, int k, int n, int i) {
        int l = i-k;
        int r = i+k;
        if(l>=0 && r<n) {
            return nums[l]<nums[r] ? l : r;
        }
        if (l<0)
            return r;

        return l;
    }


}
