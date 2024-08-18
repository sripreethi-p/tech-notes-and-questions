package com.dsa.algorithms.problems.leetcode;

public class RegionsCutBySlashes959 {
    /*
    An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '.
    These characters divide the square into contiguous regions.
    Given the grid grid represented as a string array, return the number of regions.
    Note that backslash characters are escaped, so a '\' is represented as '\\'.

    Example 1:
        Input: grid = [" /","/ "]
        Output: 2
    Example 2:
        Input: grid = [" /","  "]
        Output: 1
    Example 3:
        Input: grid = ["/\\","\\/"]
        Output: 5
    Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
     */

    /*
    Note : Solution : Imagine "/" & "\" as pieces of water & we need to find Number of Islands (200)
     */

    private final NumberOfIslands200 numberOfIslands200;

    public RegionsCutBySlashes959(NumberOfIslands200 numberOfIslands200) {
        this.numberOfIslands200 = numberOfIslands200;
    }

    public int regionsBySlashes(String[] grid) {

        // converting grid to char[][] as required by NumberOfIslands200
        int n = grid.length;

        char[][] islandGrid = new char[2*n][2*n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    islandGrid[2*i][2*j] = '1';
                    islandGrid[(2*i)+1][(2*j)+1] = '1';
                    islandGrid[2*i][(2*j)+1] = '0';
                    islandGrid[(2*i)+1][2*j] = '0';
                }
                if (grid[i].charAt(j) == '\\') {
                    islandGrid[2*i][2*j] = '0';
                    islandGrid[(2*i)+1][(2*j)+1] = '0';
                    islandGrid[2*i][(2*j)+1] = '1';
                    islandGrid[(2*i)+1][2*j] = '1';
                }
                if (grid[i].charAt(j) == ' ') {
                    islandGrid[2*i][2*j] = '1';
                    islandGrid[(2*i)+1][(2*j)+1] = '1';
                    islandGrid[2*i][(2*j)+1] = '1';
                    islandGrid[(2*i)+1][2*j] = '1';
                }
            }
        }

        return numberOfIslands200.numIslands(islandGrid);
    }
}
