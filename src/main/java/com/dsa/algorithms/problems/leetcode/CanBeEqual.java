package com.dsa.algorithms.problems.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (arr.length != target.length) {
            return false;
        }
        List<Integer> targetList = new java.util.ArrayList<>(Arrays.stream(target).boxed().toList());
        List<Integer> arrList = new java.util.ArrayList<>(Arrays.stream(arr).boxed().toList());

        Collections.sort(targetList);
        Collections.sort(arrList);

        for (int i = 0; i < targetList.size(); i++) {
            if (!targetList.get(i).equals(arrList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
