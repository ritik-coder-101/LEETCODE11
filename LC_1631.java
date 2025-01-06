// 1631. Path With Minimum Effort -{M}

// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    int INF=Integer.MAX_VALUE;

    public int minimumEffortPath(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[2] -b[2]);
        pq.offer(new int[]{0,0,0});

        int[][] effort=new int[row][col];
        for (int[] i : effort) Arrays.fill(i,INF);

        effort[0][0]=0;

        while (!pq.isEmpty()) {
            int[] coll=pq.poll();
            int r=coll[0];
            int c=coll[1];
            int e=coll[2];

            if (r == row-1 && c == col-1 ) return e;

            for (int[] dir  : direction) {
                int nr=r+dir[0];
                int nc=c+dir[1];

                if (nr>=0 && nr < row && nc >= 0 && nc < col) {
                    int ne=Math.max(e,Math.abs(heights[nr][nc] - heights[r][c]));

                    if (ne < effort[nr][nc]) {
                        effort[nr][nc] =ne;
                        pq.offer(new int[]{nr,nc,ne});
                    }
                }
            }
        }
        return 0;
    }
}