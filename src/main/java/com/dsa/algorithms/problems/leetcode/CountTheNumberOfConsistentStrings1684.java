package com.dsa.algorithms.problems.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountTheNumberOfConsistentStrings1684 {
    /*
    You are given a string allowed consisting of distinct characters and an array of strings words.
    A string is consistent if all characters in the string appear in the string allowed.
    Return the number of consistent strings in the array words.
    */

    public int countConsistentStrings(String allowed, String[] words) {
        List<Character> allowedChars = allowed.chars().mapToObj(e -> (char) e).toList();
        return (int) Arrays.stream(words).filter(word -> word.chars().allMatch(e -> allowedChars.contains((char) e))).count();
    }
}
