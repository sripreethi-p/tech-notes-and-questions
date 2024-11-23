package com.dsa.algorithms.problems.leetcode;

import java.math.BigInteger;
import java.util.*;

public class CountMaxBitwiseOrSubsets2044 {
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> numsCopy = new ArrayList<>(Arrays.stream(nums).boxed().toList());

        numsCopy.sort(Collections.reverseOrder());

        int maxBits = Integer.toBinaryString(numsCopy.get(0)).length();

        HashMap<Integer, Integer> bitMap = new HashMap<>();

        for (int i = 1; i<=maxBits; i++) {
            bitMap.put(i, 0);
        }

        for (int i = 0; i<nums.length; i++) {
            String numString = Integer.toBinaryString(numsCopy.get(i));
            int n = numString.length();

            for ( int j=0; j<n; j++) {
                if(numString.charAt(j)=='1') {
                    bitMap.compute(j+1, (k, initial) -> initial + 1);
                }
            }
        }

        int result = 0;

        for ( int i =1; i<=maxBits; i++) {
            result += nCk(bitMap.get(i), 1).intValue();
        }

        return result;

    }

    // Function to calculate factorial of a number
    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Function to calculate nCk
    public static BigInteger nCk(int n, int k) {
        if (k > n) {
            return BigInteger.ZERO;
        }
        // nCk = n! / (k! * (n-k)!)
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(k).multiply(factorial(n - k));
        return numerator.divide(denominator);
    }
}
