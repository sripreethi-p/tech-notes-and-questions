package com.dsa.algorithms.problems.tests;

import java.util.*;

public class MicrosoftTechAssessment {
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
         int n = A.length;
         int result = A[n-1]+1;

        for (int i =1; i<n; i++) {
            if(A[i]!=A[i-1]+1 && A[i]!=A[i-1]) {
                result = A[i]+1;
            }
        }
        return result;
    }


//    public int[] solution(String R, int[] V) {
//        // Implement your solution here
//        char[] receipients = R.toCharArray();
//        int N = V.length;
//
//        int minBalanceA = 0;
//        int minBalanceB = 0;
//        int currentBalanceA = 0;
//        int currentBalanceB = 0;
//
//        for (int k = 0; k < N; k++) {
//            if (receipients[k] == 'A') {
//                currentBalanceB -= V[k];
//                currentBalanceA += V[k];
//            } else if (receipients[k] == 'B') {
//
//                currentBalanceA -= V[k];
//                currentBalanceB += V[k];
//            }
//
//
//            minBalanceA = Math.min(minBalanceA, currentBalanceA);
//            minBalanceB = Math.min(minBalanceB, currentBalanceB);
//        }
//
//        return new int[] { Math.abs(minBalanceA), Math.abs(minBalanceB) };
//    }
//
//


    public static boolean solution(String[] B) {
        // Implement your solution here
        int n = B.length;
        int m = B[0].length();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = B[i].toCharArray();
        }

        boolean[][] danger = new boolean[n][m];

        markDangerZones(grid, danger, n, m);

        System.out.println("Danger Zone: " + danger[1][2]);

        int startX = -1, startY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        return bfs(grid, danger, n, m, startX, startY);
    }

    private static void markDangerZones(char[][] grid, boolean[][] danger, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '^') markDirection(grid, danger, n, m, i, j, -1, 0);
                if (grid[i][j] == 'V') markDirection(grid, danger, n, m, i, j, 1, 0);
                if (grid[i][j] == '<') markDirection(grid, danger, n, m, i, j, 0, -1);
                if (grid[i][j] == '>') markDirection(grid, danger, n, m, i, j, 0, 1);
            }
        }
    }

    private static void markDirection(char[][] grid, boolean[][] danger, int n, int m, int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '.') {
            danger[x][y] = true;
            x += dx;
            y += dy;
        }
    }

    private static boolean bfs(char[][] grid, boolean[][] danger, int n, int m, int startX, int startY) {
        if (startX == -1 || startY == -1) return false;
        if (startX == n-1 && startY == m-1) return false;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            if (x == n - 1 && y == m - 1) return true;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValidMove(grid, danger, visited, n, m, newX, newY)) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return false;
    }

    private static boolean isValidMove(char[][] grid, boolean[][] danger, boolean[][] visited, int n, int m, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && grid[x][y] == '.' && !danger[x][y];
    }

    public static void main (String[] args) {
        boolean sol = solution(new String[]{"A.v", "..."});
        System.out.println("Result: " + sol);
    }

}
