// 79. Word Search -{M}

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

class Solution {

    int[][] direction={{1,0},{0,1},{0,-1},{-1,0}};

    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (board[i][j] == word.charAt(0) && dfs(board,i,j,word,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int r,int c,String word,int index) {
        if (index == word.length()) return true;

        if (r < 0 || r>= board.length || c  < 0 || c>= board[0].length || board[r][c] != word.charAt(index)) return false;

        char temp=board[r][c];
        board[r][c]= '#';

        for (int[] dir : direction) {
            if (dfs(board,r+dir[0],c+dir[1],word,index+1)) return true;
        }
        board[r][c]=temp;
        return false;
    }
}