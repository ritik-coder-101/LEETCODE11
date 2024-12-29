// 542. 01 Matrix -{M}

// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

class Solution {
    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;

        int[][] res=new int[row][col];
        Queue<int[]> que=new LinkedList<>();

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (mat[i][j] == 0) {
                    res[i][j]=0;
                    que.offer(new int[]{i,j});
                } else {
                    res[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] coll=que.poll();
            int r=coll[0];
            int c=coll[1];

            for (int[] dir : direction) {
                int nr=r+dir[0];
                int nc=c+dir[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    if (res[nr][nc] > res[r][c]+1) {
                        res[nr][nc]=res[r][c]+1;
                        que.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return res;
    }
}