// 1219. Path with Maximum Gold - {M}

// In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

// Return the maximum amount of gold you can collect under the conditions:

// Every time you are located in a cell you will collect all the gold in that cell.
// From your position, you can walk one step to the left, right, up, or down.
// You can't visit the same cell more than once.
// Never visit a cell with 0 gold.
// You can start and stop collecting gold from any position in the grid that has some gold.

class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

    public int getMaximumGold(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int max=0;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] != 0) {
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid,int r,int c) {

        if (r < 0 || r >= grid.length || c < 0 || c>= grid[0].length || grid[r][c] == 0) return 0;

        int temp=grid[r][c];
        grid[r][c]=0;
        int gold=0;

        for (int[] dir : direction) {
            int nr=r+dir[0];
            int nc=c+dir[1];
            gold=Math.max(gold,dfs(grid,nr,nc));
        }

        grid[r][c]=temp;
        return gold+temp;
    }
}