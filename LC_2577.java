// 2577. Minimum Time to Visit a Cell In a Grid - {H}

// You are given a m x n matrix grid consisting of non-negative integers where grid[row][col] represents the minimum time required to be able to visit the cell (row, col), which means you can visit the cell (row, col) only when the time you visit it is greater than or equal to grid[row][col].

// You are standing in the top-left cell of the matrix in the 0th second, and you must move to any adjacent cell in the four directions: up, down, left, and right. Each move you make takes 1 second.

// Return the minimum time required in which you can visit the bottom-right cell of the matrix. If you cannot visit the bottom-right cell, then return -1.
class Solution {

    int[][] direction={{0,1},{1,0},{-1,0},{0,-1}};
    int INF=Integer.MAX_VALUE;

    public int minimumTime(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        if (grid[1][0] > 1 && grid[0][1] > 1) return -1;

        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        PriorityQueue<int[] > pq=new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        pq.offer(new int[]{0,0,0});

        while (!pq.isEmpty()) {
            int[] coll=pq.poll();
            int r=coll[0];
            int c=coll[1];
            int t=coll[2];

            if (r == row-1 && c == col-1) return t;

            for (int[] dir : direction) {
                int nr=dir[0]+r;
                int nc=dir[1]+c;

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc]) {
                    int w=0;
                    int diff=Math.abs(grid[nr][nc] - t);

                    if ((diff & 1) == 0) w=1;

                    int newtime=Math.max(grid[nr][nc]+w,t+1);
                    pq.offer(new int[]{nr,nc,newtime});
                    visited[nr][nc]=true;
                }
            }
        }
        return -1;
    }
}