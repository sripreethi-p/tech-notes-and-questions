package com.dsa.algorithms.problems.leetcode;

public class Set1 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] minHeights = new int[n+1];

        for (int i =1; i<=n; i++) {
            int w = books[i-1][0];
            int h = books[i-1][1];

            // initialized to when book placed in a new rack
            minHeights[i] = minHeights[i-1] + h;
            for (int j=i-1; j>0; j--) {
                w += books[j-1][0];
                if (w > shelfWidth)
                    break;
                // when placed in the same rack as jth book
                int rackHeight = Math.max(h, books[j-1][1]);
                minHeights[i] = Math.min(minHeights[i], minHeights[j-1]+rackHeight);

        }
    }
        return minHeights[n];
    }
}
