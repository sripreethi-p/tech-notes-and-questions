package com.dsa.algorithms.problems.leetcode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KthDistinctStringInAnArray {

    /*
    A distinct string is a string that is present only once in an array.
    Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
    If there are fewer than k distinct strings, return an empty string "".
    Note that the strings are considered in the order in which they appear in the array.
     */

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
        List<Map.Entry<String, Integer>> distinctEntries = map.entrySet().stream().filter(entry -> entry.getValue()==1).toList();
        if (distinctEntries.size() >= k-1) {
            return distinctEntries.get(k-1).getKey();
        }
        return "";

    }
}
