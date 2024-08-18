package com.dsa.algorithms.problems.leetcode;


import java.util.Arrays;
import java.util.Set;

public class MaximumNoOfPointsWithCost {

    /*
    You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
    To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
    However, you will lose points if you pick a cell too far from the cell that you picked in the previous row.
    For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
    Return the maximum number of points you can achieve.
     */
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        long[] localDp = new long[n];

        for (int i = 0; i < n; i++) {
            localDp[i] = points[0][i];
            dp[i] = points[0][i];
        }

        if(m<2) {
            return getMax(dp, n);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                localDp[j] = getMaxPoints(points, n, i, j, dp);
            }
            System.arraycopy(localDp, 0, dp, 0, n);

        }


        return getMax(dp, n);
    }

    public long getMax(long[] dp, int n) {
        long maxPoints = 0;
        for (int i = 0; i<n; i++) {
            if(dp[i] > maxPoints) {
                maxPoints = dp[i];
            }
        }

        return maxPoints;
    }

    public long getMaxPoints(int[][] points, int n, int r, int c, long[] weights) {
        long maxWeight = 0;
        long weight;
        for (int i=0; i < n; i++) {
            weight = weights[i]+ points[r][c] - Math.abs(c-i);
            if(weight > maxWeight) {
                maxWeight = weight;
            }
        }
        return maxWeight;
    }

}
