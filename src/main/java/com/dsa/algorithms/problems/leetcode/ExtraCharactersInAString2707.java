package com.dsa.algorithms.problems.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExtraCharactersInAString2707 {

    /*
    You are given a 0-indexed string s and a dictionary of words dictionary.
    You have to break s into one or more non-overlapping substrings such that each substring is present in the dictionary.
    There may be some extra characters in s that are not present in any of the substrings.
    Return the minimum number of extra characters left over if you break up optimally.

       //  SOLUTION explanation https://www.youtube.com/watch?v=9yr-TrezhKs

     */

    int[] dp = new int[55];

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dictionarySet = Arrays.stream(dictionary).collect(Collectors.toSet());

        for (int i =0; i<55; i++) {
            dp[i] = -1;
        }

        return solve(0, s.length(), s, dictionarySet);
    }

    public int solve (int i, int n, String s, Set<String> dictionary) {
        if(i>=n) {
            return 0;
        }

        if(dp[i]!= -1) {
            return dp[i];
        }

        // considering ith is an extra character
        int result = 1 + solve(i+1, n, s, dictionary);

        for (int j = i; j<n; j++) {
            if(dictionary.contains(s.substring(i, j+1))) {
                result = Math.min(result, solve(j+1, n, s, dictionary));
            }
        }

        return dp[i] = result;

    }


}
