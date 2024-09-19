package com.dsa.algorithms.problems;

import java.util.HashSet;

public class LongestSubstringWithUniqueChars {
    public static int longestSubstringWithDistinctChars(String s) {
        // HashSet to store the characters in the current window
        HashSet<Character> set = new HashSet<>();

        int maxLength = 0;  // Variable to store the maximum length of substring
        int left = 0; // Left pointer of the sliding window

        int outerCounter = 0;
        int innerCounter = 0;

        // Traverse the string using the right pointer
        for (int right = 0; right < s.length(); right++) {
            outerCounter++;
            char currentChar = s.charAt(right);

            // If the character is already in the set, remove characters from the left
            // until we remove the duplicate character
            while (set.contains(currentChar)) {
                innerCounter++;
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }


        System.out.println("Outer time: " + outerCounter + ", Inner time: " + innerCounter);

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "aaabbbcccdddeeefffggghhhiiijjjkkklllmmmnnnooopppqqqrrrssstttuuuvvvwwwxxxyyyzzz";
        int result = longestSubstringWithDistinctChars(input);
        System.out.println("The length of the longest substring with distinct characters is: " + result);
    }
}
