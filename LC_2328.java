// 2328. Number of Increasing Paths in a Grid -{H}

// You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

// Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell. Since the answer may be very large, return it modulo 109 + 7.

// Two paths are considered different if they do not have exactly the same sequence of visited cells.


class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    int[][] memo;
    int MOD=1_000_000_007;

    public int countPaths(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        memo=new int[row][col];
        int sum=0;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                sum=(sum+dfs(grid,i,j))%MOD;
            }
        }
        return sum;
    }

    private int dfs(int[][] grid,int r,int c) {
        if (memo[r][c] != 0) return memo[r][c];

        int sum=1;

        for (int[] dir : direction) {
            int nr=r+dir[0];
            int nc=c+dir[1];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] > grid[r][c]) {
                sum=(sum+dfs(grid,nr,nc))%MOD;
            }
        }

        memo[r][c]=sum;
        return sum;
    }
}