// 1091. Shortest Path in Binary Matrix - {M}

// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path.

class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        if (grid[0][0] == 1 || grid[row-1][col-1] ==1 ) return -1;

        Queue<int[] > que=new LinkedList<>();
        que.offer(new int[]{0,0,1});

        while (!que.isEmpty()) {
            int[] coll=que.poll();
            int r=coll[0];
            int c=coll[1];
            int p=coll[2];

            if (r == row-1 && c == col-1) return p;

            for (int[] dir: direction) {
                int nr=r+dir[0];
                int nc=c+dir[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    que.offer(new int[]{nr,nc,p+1});
                }
            }
        }
        return -1;
    }
}