// 994. Rotting Oranges - {M}
// 
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        Queue<int[]> que=new LinkedList<>();
        int fresh=0;
        
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i,j,0});
                } else if (grid[i][j] ==1 ) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int time=0;

        while (!que.isEmpty()) {
            int[] coll=que.poll();
            int r=coll[0];
            int c=coll[1];
            int t=coll[2];
            time=t;

            for (int[] dir : direction) {
                int nr=r+dir[0];
                int nc=c+dir[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                    grid[nr][nc]=2;
                    que.offer(new int[]{nr,nc,t+1});
                    fresh--;
                }
            }
        }
        return (fresh == 0) ? time : -1;
    }
}