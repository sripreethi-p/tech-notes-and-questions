package com.dsa.algorithms.problems.leetcode;

/*
    The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
    For example, integer 5 is "101" in binary and its complement is "010" which is the integer 2.
    Given an integer num, return its complement.
 */
public class NumberComplement476 {
    public int findComplement(int num) {
        int bitLength = Integer.toBinaryString(num).length();
        int res = 0;
        for (int i=0; i<bitLength; i++) {
            res += (int) Math.pow(2, i);
        }

        return res^num;

    }
}
