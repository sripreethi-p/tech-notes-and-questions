package com.dsa.algorithms.problems.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MagicSquareInAGrid840 {

    /*
    A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
    Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?
    Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
     */

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int counter = 0;
        for (int i=0; i<rows-2; i++) {
            for (int j=0; j<cols-2; j++) {
                if(isMagicSquare(grid, i, j)) {
                    counter++;
                }
            }
        }
        return counter;

    }

    private Boolean isMagicSquare(int[][] grid, int i, int j) {
        if(!isValidSquare(grid, i, j)) return false;

        List<Integer> line = Arrays.asList(grid[i][j], grid[i][j+1], grid[i][j+2]);

        int sum = getSum(line);

        line = Arrays.asList(grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2]);
        if(sum!=getSum(line)) return false;

        line = Arrays.asList(grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2]);
        if(sum!=getSum(line)) return false;

        line = Arrays.asList(grid[i][j], grid[i+1][j], grid[i+2][j]);
        if(sum!=getSum(line)) return false;

        line = Arrays.asList(grid[i][j+1], grid[i+1][j+1], grid[i+2][j+1]);
        if(sum!=getSum(line)) return false;

        line = Arrays.asList(grid[i][j+2], grid[i+1][j+2], grid[i+2][j+2]);
        if(sum!=getSum(line)) return false;

        line = Arrays.asList(grid[i][j], grid[i+1][j+1], grid[i+2][j+2]);
        if(sum!=getSum(line)) return false;

        line = Arrays.asList(grid[i][j+2], grid[i+1][j+1], grid[i+2][j]);
        return sum == getSum(line);
    }

    private Boolean isValidSquare(int[][] grid, int startRow, int startColumn) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startColumn; j < startColumn+3; j++) {
                int number = grid[i][j];
                set.add(number);
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private Integer getSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}
