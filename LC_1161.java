// 1161. Maximum Level Sum of a Binary Tree -{M};
// Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
// Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return -1;

        int maxl=0;
        int lvls=Integer.MIN_VALUE;
        int lvl=1;

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size=que.size();
            int sum=0;

            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();
                sum+=node.val;

                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }
            }

            if (lvls < sum) {
                lvls=sum;
                maxl=lvl;
            }
            lvl++;
        }
        return maxl;
    }
}