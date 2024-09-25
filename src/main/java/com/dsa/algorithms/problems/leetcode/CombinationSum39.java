package com.dsa.algorithms.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    /*
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
    of at least one of the chosen numbers is different.
    The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
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

        combination.add(candidates[index]);
        findCombinations(candidates, result, combination, index, totalLeft-candidates[index]);
        combination.remove(combination.size()-1);
        findCombinations(candidates, result, combination, index+1, totalLeft);
    }
}
