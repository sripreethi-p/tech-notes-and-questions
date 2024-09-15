package com.dsa.algorithms.problems.leetcode;

public class XORQueriesOfASubArray1310 {
    /*
    You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.
     */


    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = arr.length;
        int n = queries.length;

        int[] result = new int[n];
        int[] xor = new int[m];

        xor[0] = arr[0];
        for (int i =1; i<m; i++) {
            xor[i] = arr[i] ^ xor[i-1];
        }

        for (int i=0; i<n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if(start!=0) {
                result[i] = xor[end] ^ xor[start-1];
            }
            else {
                result[i] = xor[end];
            }
        }

        return result;


    }
}
