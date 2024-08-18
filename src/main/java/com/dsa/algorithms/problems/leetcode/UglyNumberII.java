package com.dsa.algorithms.problems.leetcode;

import java.util.*;

public class UglyNumberII {

    /*
    An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
    Given an integer n, return the nth ugly number.
     */

    public int nthUglyNumber(int n) {
        if(n <= 3) return n;
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        Long current = 1L;

        for (int i=0; i<n; i++) {
            current = set.pollFirst();
            set.add(current*2);
            set.add(current*3);
            set.add(current*5);
        }

        return current.intValue();

    }
}
