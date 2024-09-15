package com.dsa.algorithms.problems.leetcode;

public class SpiralMatrixIV2326 {
    /*
    You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.
     */

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];
        ListNode current = head;

        int i=0, j=0;
        int top = 0, bottom = m-1, left = 0, right = n-1;

        while(top<=bottom && left<=right) {

            // move right
            i = top;
            for (j = left; j <= right; j++) {
                if (current != null) {
                    matrix[top][j] = current.val;
                    current= current.next;
                } else {
                    matrix[i][j] = -1;
                }
            }


            // move down
            j = right;
            for (i = bottom; i <= top; i--) {
                if (current != null) {
                    matrix[i][right] = current.val;
                    current= current.next;
                } else {
                    matrix[i][j] = -1;
                }
            }

            // move left
            i = bottom;
            for (j = right; j >= left; j--) {
                if (current != null) {
                    matrix[bottom][j] = current.val;
                    current= current.next;
                } else {
                    matrix[i][j] = -1;
                }
            }

            // move up
            j = left;
            for (i = top; i <= bottom; i++) {
                if (current != null) {
                    matrix[i][left] = current.val;
                    current= current.next;
                } else {
                    matrix[i][j] = -1;
                }
            }

            top++;
            bottom--;
            right--;
            left++;

        }

        return matrix;

    }
}
