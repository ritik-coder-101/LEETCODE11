// 1926. Nearest Exit from Entrance in Maze - {M}

// You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

// In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

// Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int row=maze.length;
        int col=maze[0].length;

        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[]{entrance[0],entrance[1],0});

        boolean[][] path=new boolean[row][col];

        path[entrance[0]][entrance[1]]=true;

        while (!que.isEmpty()) {
            int[] coll=que.poll();
            int r=coll[0];
            int c=coll[1];
            int p=coll[2];

            if ((r == 0 || c == 0 || r == row-1 || c == col-1) && !(r == entrance[0] && c == entrance[1])) {
                return p;
            }

            for (int[] dir : direction) {
                int nr=dir[0]+r;
                int nc=dir[1]+c;

                if (nr >= 0 && nr <row && nc >= 0 && nc < col && maze[nr][nc] == '.' && !path[nr][nc]) {
                    path[nr][nc]=true;
                    que.offer(new int[]{nr,nc,p+1});
                }
            }
        }
        return -1;
    }
} {
    
}
