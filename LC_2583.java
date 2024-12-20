// 2583. Kth Largest Sum in a Binary Tree - {M}

// You are given the root of a binary tree and a positive integer k.

// The level sum in the tree is the sum of the values of the nodes that are on the same level.

// Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

// Note that two nodes are on the same level if they have the same distance from the root

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        PriorityQueue<Long> pq=new PriorityQueue<>((a,b) -> Long.compare(b,a));
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size=que.size();
            long sum=0;

            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();
                sum+=node.val;

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            pq.offer(sum);
        }

        while (k-- > 1 && !pq.isEmpty()) {
           System.out.print(pq.poll()+": ");
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}