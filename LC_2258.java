// 2258. Escape the Spreading Fire -{M}

// You are given a 0-indexed 2D integer array grid of size m x n which represents a field. Each cell has one of three values:

// 0 represents grass,
// 1 represents fire,
// 2 represents a wall that you and fire cannot pass through.
// You are situated in the top-left cell, (0, 0), and you want to travel to the safehouse at the bottom-right cell, (m - 1, n - 1). Every minute, you may move to an adjacent grass cell. After your move, every fire cell will spread to all adjacent cells that are not walls.

// Return the maximum number of minutes that you can stay in your initial position before moving while still safely reaching the safehouse. If this is impossible, return -1. If you can always reach the safehouse regardless of the minutes stayed, return 109.

// Note that even if the fire spreads to the safehouse immediately after you have reached it, it will be counted as safely reaching the safehouse.

// A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).

class Solution {
    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    int INF=Integer.MAX_VALUE;
    public int maximumMinutes(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int[][] firetime=new int[row][col];
        for (int[] i : firetime) {
            Arrays.fill(i,INF);
        }

        Queue<int[] > que=new LinkedList<>();

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == 1) {
                    que.offer(new int[] {i,j});
                    firetime[i][j]=0;
                }
            }
        }
        int time=0;

        while (!que.isEmpty()) {
            int size=que.size();
            time++;

            for (int i=0;i<size;i++) {
                int[] coll=que.poll();
                int r=coll[0];
                int c=coll[1];

                for (int[] dir : direction) {
                    int nr=dir[0]+r;
                    int nc=dir[1]+c;

                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0 && firetime[nr][nc] == INF) {
                        que.offer(new int[]{nr,nc});
                        firetime[nr][nc]=time;
                    }
                }
            }
        }

        //people time;
        int[][] peopletime=new int[row][col];
        for (int[] i : peopletime) {
            Arrays.fill(i,INF);
        }
        time=0;
        que.offer(new int[]{0,0});
        peopletime[0][0]=0;

        while (!que.isEmpty()) {
            int size=que.size();
            time++;

            for (int i=0;i<size;i++) {
                int[] coll=que.poll();
                int r=coll[0];
                int c=coll[1];

                for (int[] dir : direction) {
                    int nr=dir[0]+r;
                    int nc=dir[1]+c;

                    if (nr>=0 && nr < row && nc >=0 && nc < col && grid[nr][nc] == 0 && peopletime[nr][nc] == INF && firetime[nr][nc] > time) {
                        que.offer(new int[]{nr,nc});
                        peopletime[nr][nc]=time;
                    }
                }
                if (((r == row-2 && c == col-1) || (r == row-1 && c == col-2)) && firetime[row-1][col-1] <= time) {
                    que.offer(new int[]{row-1,col-1});
                    peopletime[row-1][col-1]=time;
                }
            }
        }

        if (peopletime[row-1][col-1] == INF || firetime[row-1][col-1] < peopletime[row-1][col-1]) return -1;

        if (firetime[row-1][col-1] == INF) return (int)1e9;

        if (firetime[row-1][col-1] == peopletime[row-1][col-1]) return 0;

        int diff=(firetime[row-1][col-1] - peopletime[row-1][col-1]);
        if (peopletime[row-2][col-1] != INF && peopletime[row-1][col-2] != INF && (firetime[row-2][col-1] - peopletime[row-2][col-1]> diff || firetime[row-1][col-2] -peopletime[row-1][col-2] > diff)) {
            return diff;
        }
        return diff-1;


        // return firetime[row-1][col-1] == INF ?(int) 1e9 : firetime[row-1][col-1];
        // return peopletime[row-1][col-1];
    }
}