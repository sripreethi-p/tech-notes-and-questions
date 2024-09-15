package com.dsa.algorithms.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts1371 {
    /*
    Given the string s, return the size of the longest substring containing each vowel an even number of times.
    That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
     */

    public int findTheLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        int n = s.length();
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);

        for (int i = 0; i<n; i++) {
            if(vowels.containsKey(s.charAt(i))) {
                vowels.put(s.charAt(i), vowels.get(s.charAt(i)) + 1);

            }
        }

        return maxLength;
    }
}
