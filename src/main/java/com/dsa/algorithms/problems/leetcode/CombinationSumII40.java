package com.dsa.algorithms.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    /*
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
    Note: The solution set must not contain duplicate combinations.

    Example 1:
        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output:
            [
                [1,1,6],
                [1,2,5],
                [1,7],
                [2,6]
            ]
    Example 2:
        Input: candidates = [2,5,2,1,2], target = 5
        Output:
            [
                [1,2,2],
                [5]
            ]
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, result, combo, 0, target);

        return result;
    }



    private void findCombinations(int[] candidates, List<List<Integer>> result, List<Integer> combination, int index, int totalLeft) {
        if(totalLeft==0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if(totalLeft<0 || index>=candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length && totalLeft>=candidates[i]; i++) {
            if (i>index && candidates[i]==candidates[i-1]) continue;
            combination.add(candidates[i]);
            findCombinations(candidates, result, combination, i+1, totalLeft-candidates[i]);
            combination.remove(combination.size()-1);
        }
    }
}
