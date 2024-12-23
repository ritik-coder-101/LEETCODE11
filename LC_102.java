// 102. Binary Tree Level Order Traversal -{M}

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if (root == null ) return list;

        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size=que.size();
            List<Integer> list1=new ArrayList<>();

            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();
                list1.add(node.val);

                if (node.left!= null) que.offer(node.left);
                if (node.right != null ) que.offer(node.right);
            }
            list.add(list1);
        }
        return list;
    }
}