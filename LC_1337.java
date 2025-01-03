// 1337. The K Weakest Rows in a Matrix - {E}

// You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

// A row i is weaker than a row j if one of the following is true:

// The number of soldiers in row i is less than the number of soldiers in row j.
// Both rows have the same number of soldiers and i < j.
// Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row=mat.length;
        int col=mat[0].length;

        PriorityQueue<int[] > pq=new PriorityQueue<>((a,b) -> {
            if (b[1] == a[1]) {
                return a[0] - b[0];
            } else {
                return a[1]-b[1];
            }
        });

        for (int i=0;i<row;i++) {
            int count=0;
            for (int j=0;j<col;j++) {
                if (mat[i][j] == 1) count++;
                else break;
            }
            pq.offer(new int[]{i,count});
        }
        int[] res=new int[k];

        for (int i=0;i<k;i++) {
            int[] coll=pq.poll();
            res[i]=coll[0];
        }
        return res;
    }
}