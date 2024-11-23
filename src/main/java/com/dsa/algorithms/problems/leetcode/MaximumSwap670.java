package com.dsa.algorithms.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumSwap670 {


    public int maximumSwap(int num) {
        List<Integer> digits = getDigits(num);

        int n = digits.size();
        int i = n-1;

        while (i>0) {
            boolean swap = false;
             int max = digits.get(i);
            for ( int j = i-1; j>=0; j--) {
                if (digits.get(j) > digits.get(max)) {
                    swap = true;
                    max = j;
                }
            }

            if(swap) {
                int temp = digits.get(i);
                digits.set(i, digits.get(max));
                digits.set(max, temp);
                i = -1;
            }
            else {
                i--;
            }
        }



        return getNum(digits);
    }

    private int getNum(List<Integer> digits) {
        int num = 0;
        for (int i =digits.size()-1; i>=0; i--) {
            num = (num*10) + digits.get(i);
        }

        return num;
    }
    private List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num>0) {
            int digit = num%10;
            num = num/10;
            digits.add(digit);
        }

        return digits;
    }
}
