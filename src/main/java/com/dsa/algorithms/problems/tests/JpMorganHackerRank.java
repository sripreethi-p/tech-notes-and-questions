package com.dsa.algorithms.problems.tests;

import java.util.List;

public class JpMorganHackerRank {
    public static void fizzBuzz(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0) {
                System.out.println("Fizz");
            }
            else if(i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }


    public static char slowestKey(List<List<Integer>> keyTimes) {
        // Write your code here
        int n = keyTimes.size();
        int maxTime = keyTimes.get(0).get(1);
        int maxCharAscii = keyTimes.get(0).get(0);

        for (int i = 1; i<n; i++) {
            if ((keyTimes.get(i).get(1)-keyTimes.get(i-1).get(1)) > maxTime) {
                maxTime = keyTimes.get(i).get(1)-keyTimes.get(i-1).get(1);
                maxCharAscii = keyTimes.get(i).get(0);
            }
        }

        int ascii = maxCharAscii+97;
        return (char) ascii;

    }
}
