package com.dsa.algorithms.problems.leetcode;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = extractLiveNeighbors(board, i, j, m, n);
                if (board[i][j] == 0) {
                    if(liveNeighbors==3) {
                        board[i][j] = 2;
                    }
                }
                else if(board[i][j] == 1) {
                    if (liveNeighbors!=2 && liveNeighbors!=3) {
                        board[i][j] = -2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if(board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }

    }

    private int extractLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int count = 0;
        if(row>=1) {
            count += checkLive(board[row-1][col]);
            if(col>=1) {
                count += checkLive(board[row-1][col-1]);
            }
            if(col<n-1) {
                count += checkLive(board[row-1][col+1]);
            }
        }

        if(row<m-1) {
            count += checkLive(board[row+1][col]);
            if(col>=1) {
                count += checkLive(board[row+1][col-1]);
            }
            if(col<n-1) {
                count += checkLive(board[row+1][col+1]);
            }
        }

        if(col>=1) {
            count += checkLive(board[row][col-1]);
        }
        if(col<n-1) {
            count += checkLive(board[row][col+1]);
        }
        return count;
    }

    private int checkLive(int val) {
        return val == 1 || val == -2 ? 1 : 0;
    }
}
