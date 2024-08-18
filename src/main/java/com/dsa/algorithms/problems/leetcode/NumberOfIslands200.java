package com.dsa.algorithms.problems.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands200 {
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
    Example 1:
        Input: grid = [
                        ["1","1","1","1","0"],
                        ["1","1","0","1","0"],
                        ["1","1","0","0","0"],
                        ["0","0","0","0","0"]
                       ]
               Output: 1
    Example 2:
        Input: grid = [
                        ["1","1","0","0","0"],
                        ["1","1","0","0","0"],
                        ["0","0","1","0","0"],
                        ["0","0","0","1","1"]
                      ]
        Output: 3
     */

    /*
    Note : Solution : This is a BFS application.
     */
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1' && !visited.contains(i+","+j)) {
                    numOfIslands++;
                    bfs(grid, i, j, visited, rows, cols);
                }
            }
        }

        return numOfIslands;
    }

    private void bfs(char[][] grid, int row, int col, Set<String> visited, int rows, int cols) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int []> queue = new LinkedList<>();

        visited.add(row+","+col);
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int[] direction : directions) {
                int x = node[0] + direction[0];
                int y = node[1] + direction[1];

                if (x>=0 && x<rows && y>=0 && y<cols && grid[x][y]=='1' && !visited.contains(x+","+y)) {
                    queue.add(new int[]{x, y});
                    visited.add(x+","+y);
                }
            }
        }
    }

}
