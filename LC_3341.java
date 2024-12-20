// 2577. Minimum Time to Visit a Cell In a Grid - {M}
// There is a dungeon with n x m rooms arranged as a grid.

// You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.

// Return the minimum time to reach the room (n - 1, m - 1).

// Two rooms are adjacent if they share a common wall, either horizontally or vertically.

class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    int INF=Integer.MAX_VALUE;

    public int minTimeToReach(int[][] moveTime) {
        int row=moveTime.length;
        int col=moveTime[0].length;

        int[][] time=new int[row][col];

        for (int[] i : time) Arrays.fill(i,INF);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});

        time[0][0]=0;

        while (!pq.isEmpty()) {
            int[] coll=pq.poll();
            int r=coll[0];
            int c=coll[1];
            int t=coll[2];

            if (r == row-1 && c == col-1) return t;

            for (int[] dir : direction) {
                int nr=dir[0]+r;
                int nc=dir[1]+c;

                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    int newtime=Math.max(t,moveTime[nr][nc])+1;

                    if ( newtime < time[nr][nc]) {
                        time[nr][nc]=newtime;
                        pq.offer(new int[]{nr,nc,newtime});
                    }
                }
            }
        }
        return -1;
    }
}