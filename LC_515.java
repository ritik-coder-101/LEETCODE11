// 515. Find Largest Value in Each Tree Row -{M}
// Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size=que.size();
            int max=Integer.MIN_VALUE;

            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();
                max=Math.max(max,node.val);

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }

            list.add(max);
        }
        return list;
    }
}