package com.dsa.algorithms.problems.leetcode;

import java.util.Arrays;



/*
    Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
    The objective of the game is to end with the most stones.
    Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
    On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
    The game continues until all the stones have been taken.
    Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 */


/*
    Concepts: Dynamic Programming, Recursion, Memoization, Game Theory
    Difficulty Level: Medium
 */


public class StoneProblemII1140 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int [][][] dp = new int[2][n+1][n+1];
        for (int i = 0; i <=1; i++) {
            for (int j = 0; j <=n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solveForAlice(piles, n, dp, 1, 0, 1);

    }

    private int solveForAlice(int[] piles, int n, int[][][] dp, int person, int i, int M) {
        if(dp[person][i][M] != -1) return dp[person][i][M];
        if(i>=n) return 0;

        int result;
        int stones = 0;

        result = (person==1) ? -1 : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(2*M, n-i); x++) {
            stones += piles [x+i-1];

            /*
            When it's Alice's (your) turn, you would want the best.
            So, the result would be the max of current chosen amount piles + what Alice scores next
             */
            if(person==1) {
                result = Math.max(result, stones+solveForAlice(piles, n, dp, 0, i+x, Math.max(x, M)));
            }

            /*
            When it's Bob's (opponent's) turn, you would expect the worst (Alice's worst - this function returns Alice's stones).
            So, the result would be the min of Alice's later choices (when it's Bob's turn)
             */
            else {
                result = Math.min(result, solveForAlice(piles, n, dp, 1, i+x, Math.max(x, M)));
            }
        }

        dp[person][i][M] = result;
        return result;
    }

}
