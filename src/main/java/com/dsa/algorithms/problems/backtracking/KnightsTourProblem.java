package com.dsa.algorithms.problems.backtracking;

public class KnightsTourProblem {
    int N;

    private Boolean isSafe(int x, int y, int[][] board) {
        return x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1;
    }

    private Boolean solveKTUtil(int x, int y, int movei, int[][] board, int[] xMove, int[] yMove) {
        int next_x, next_y;
        if (movei == N*N) {
            return true;
        }

        for (int k=0; k<N; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];

            // bounding codition
            if (isSafe(next_x, next_y, board)) {
                board[next_x][next_y] = movei;
                if(solveKTUtil(next_x, next_y, movei+1, board, xMove, yMove)) {
                    return true;
                }
                else {
                    board[next_x][next_y] = -1;
                }
            }
        }

        return false;

    }
    public int[][] solveNQueen() {
        int[][] board = new int [N][N];

        // initializing to unvisited (-1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // possible moves
        int[] xMove = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yMove = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};

        // since the knight is already places in the first cell
        board[0][0] = 0;


        // DFS approach
        if(solveKTUtil(0, 0, 1, board, xMove, yMove)) {
            return board;
        }
        else {
            return null;
        }

    }
}
