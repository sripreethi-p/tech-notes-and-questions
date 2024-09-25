package com.dsa.algorithms.problems.leetcode;

import java.util.*;

public class FindTheLengthOfTheLongestCommonPrefix3043 {
    /*
    You are given two arrays with positive integers arr1 and arr2.

A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit. For example, 123 is a prefix of the integer 12345, while 234 is not.

A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b. For example, 5655359 and 56554 have a common prefix 565 while 1223 and 43456 do not have a common prefix.

You need to find the length of the longest common prefix between all pairs of integers (x, y) such that x belongs to arr1 and y belongs to arr2.

Return the length of the longest common prefix among all pairs. If no common prefix exists among them, return 0.
     */

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        int m = arr1.length;

        List<Map<String, Set<Integer>>> digitsMap = new ArrayList<>();

        for (int i =0; i<10; i++) {
            Map<String, Set<Integer>> numMap = new HashMap<>();

            for (int j = 0; j<=9; j++) {
                Set<Integer> nums = new HashSet<>();
                numMap.put(Integer.toString(j), nums);
            }

            digitsMap.add(numMap);
        }

        populateDigits(arr1, digitsMap);
        return getMaxCommonPrefixLength(arr2, digitsMap, m);


    }

    public void populateDigits (int[] arr, List<Map<String, Set<Integer>>> digitsMap) {
        for (int i =0; i<arr.length; i++) {
            String intString = Integer.toString(arr[i]);

            for ( int j = 0; j<intString.length(); j++) {
                Set<Integer> nums = digitsMap.get(j).get(String.valueOf(intString.charAt(j)));
                nums.add(i);

                Map<String, Set<Integer>> map = digitsMap.get(j);
                map.put(String.valueOf(intString.charAt(j)), nums);

            }
        }
    }

    public int getMaxCommonPrefixLength(int[] arr, List<Map<String, Set<Integer>>> digitsMap, int m) {
        int count = 0;

        for (int i =0; i<arr.length; i++) {

            int currCount = 0;
            Set<Integer> arrIndexes = new HashSet<>();
            for (int k = 0; k<m; k++) {
                arrIndexes.add(k);
            }


            String intString = Integer.toString(arr[i]);

            int j = 0;
            while (j<intString.length()) {
                Map<String, Set<Integer>> map = digitsMap.get(j);
                String digit = String.valueOf(intString.charAt(j));

                arrIndexes.retainAll(map.get(digit));

                if(!arrIndexes.isEmpty()) {
                    currCount++;
                }

                j++;
            }

            count = Math.max(count, currCount);

        }

        return count;
    }


}
