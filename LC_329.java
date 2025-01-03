// 329. Longest Increasing Path in a Matrix -{H}

// Given an m x n integers matrix, return the length of the longest increasing path in matrix.

// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

class Solution {
    int[][] direction={{1,0},{0,1},{0,-1},{-1,0}};
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        memo=new int[row][col];
        int max=0;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                max=Math.max(max,dfs(matrix,i,j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix,int r,int c) {
        if (memo[r][c] != 0) return memo[r][c];

        int length=1;

        for (int[] dir : direction) {
            int nr=r+dir[0];
            int nc=c+dir[1];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]) {
                length=Math.max(length,1+dfs(matrix,nr,nc));
            }
        }
        memo[r][c]=length;
        return length;
    }
}