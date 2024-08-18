package com.dsa.algorithms.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII885 {
    /*
    You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid,
    and the southeast corner is at the last row and column.
    You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary,
    we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
    Return an array of coordinates representing the positions of the grid in the order you visited them.
     */

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> cells = new ArrayList<>();
        int limit = Math.max(rows, cols);
        int counter = 0;
        int currentI = rStart;
        int currentJ = cStart;
        int[] currentCell = new int[2];
        currentCell[0] = currentI;
        currentCell[1] = currentJ;
        cells.add(currentCell);


        int north = 0, east = 1, south = 1, west = 2;
        while (counter < limit) {
            int moves;

            moves = 0;
            while (moves < north) {
                currentI -= 1;
                int[] cell = new int[2];
                cell[0] = currentI;
                cell[1] = currentJ;
                if (isCellInGrid(cell, rows, cols)) {
                    cells.add(cell);
                }
                moves++;
            }

            moves = 0;
            while (moves < east) {
                currentJ += 1;
                int[] cell = new int[2];
                cell[0] = currentI;
                cell[1] = currentJ;
                if (isCellInGrid(cell, rows, cols)) {
                    cells.add(cell);
                }
                moves++;
            }

            moves = 0;
            while (moves < south) {
                currentI += 1;
                int[] cell = new int[2];
                cell[0] = currentI;
                cell[1] = currentJ;
                if (isCellInGrid(cell, rows, cols)) {
                    cells.add(cell);
                }
                moves++;
            }

            moves = 0;
            while (moves < west) {
                currentJ -= 1;
                int[] cell = new int[2];
                cell[0] = currentI;
                cell[1] = currentJ;
                if (isCellInGrid(cell, rows, cols)) {
                    cells.add(cell);
                }
                moves++;
            }

            counter++;
            north += 2;
            east += 2;
            south += 2;
            west += 2;
        }


        return cells.toArray(new int[cells.size()][]);

    }

    private Boolean isCellInGrid(int[] cell, int rows, int cols) {
        return cell[0] < rows && cell[0] >= 0 && cell[1] < cols && cell[1] >= 0;
    }
}
