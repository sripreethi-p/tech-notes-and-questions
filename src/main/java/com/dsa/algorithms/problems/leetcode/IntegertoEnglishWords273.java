package com.dsa.algorithms.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegertoEnglishWords273 {
    /*
    Convert a non-negative integer num to its English words representation.
    Example 1:
        Input: num = 123
        Output: "One Hundred Twenty Three"
    Example 2:
        Input: num = 12345
        Output: "Twelve Thousand Three Hundred Forty Five"
    Example 3:
        Input: num = 1234567
        Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     */

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        Map<Integer, String> words = getWords();
        Map<Integer, String> wordsForTenCubes = getCounterMap();

        StringBuilder numInWords = new StringBuilder();
        int counter = 0;

        while (num != 0) {

            StringBuilder currentWord = new StringBuilder();
            counter++;
            int curr = num % 1000;
            num = num / 1000;

            int ones = curr % 10;
            curr = curr / 10;
            int tens = curr % 10;
            curr = curr / 10;
            int hundreds = curr % 10;

            System.out.println("Ones: " + ones);
            System.out.println("\nTens : " + tens);
            System.out.println("\nHundreds : " + hundreds);

            if (hundreds != 0) {
                currentWord.append(words.get(hundreds));
                currentWord.append(" Hundred ");
            }
            if (tens != 1) {

                if (tens != 0) {
                    currentWord.append(words.get(tens * 10));
                }

                if (ones != 0) {
                    currentWord.append(words.get(ones));
                }
            }
            if (tens == 1) {
                currentWord.append(words.get(tens * 10 + ones));
            }

            String term = wordsForTenCubes.get(counter);

            if (!currentWord.isEmpty()) {
                currentWord.append(term);
            }
            numInWords.insert(0, currentWord);

        }

        return numInWords.toString().trim().replace("  ", " ");

    }

    private Map<Integer, String> getWords() {
        Map<Integer, String> words = new HashMap<>();
        words.put(1, " One");
        words.put(2, " Two");
        words.put(3, " Three");
        words.put(4, " Four");
        words.put(5, " Five");
        words.put(6, " Six");
        words.put(7, " Seven");
        words.put(8, " Eight");
        words.put(9, " Nine");
        words.put(10, " Ten");
        words.put(11, " Eleven");
        words.put(12, " Twelve");
        words.put(13, " Thirteen");
        words.put(14, " Fourteen");
        words.put(15, " Fifteen");
        words.put(16, " Sixteen");
        words.put(17, " Seventeen");
        words.put(18, " Eighteen");
        words.put(19, " Nineteen");
        words.put(20, " Twenty");
        words.put(30, " Thirty");
        words.put(40, " Forty");
        words.put(50, " Fifty");
        words.put(60, " Sixty");
        words.put(70, " Seventy");
        words.put(80, " Eighty");
        words.put(90, " Ninety");
        return words;
    }

    private Map<Integer, String> getCounterMap() {
        Map<Integer, String> counterMap = new HashMap<>();
        counterMap.put(1, "");
        counterMap.put(2, " Thousand");
        counterMap.put(3, " Million");
        counterMap.put(4, " Billion");

        return counterMap;
    }
}