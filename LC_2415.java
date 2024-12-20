// 2415. Reverse Odd Levels of Binary Tree -{M}

// Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

// For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
// Return the root of the reversed tree.

// A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

// The level of a node is the number of edges along the path between it and the root node.
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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        boolean flag=false;

        while (!que.isEmpty()) {
            int size=que.size();
            List<TreeNode> list=new ArrayList<>();
            
            for (int i=0;i<size;i++) {
                TreeNode a=que.poll();
                list.add(a);
                if (a.left != null) {
                    que.offer(a.left);
                }

                if (a.right != null) {
                    que.offer(a.right);
                }
            }
            if (flag) {
                int left=0;
                int right=list.size()-1;
                while (left < right) {
                    int temp=list.get(left).val;
                    list.get(left).val=list.get(right).val;
                    list.get(right).val=temp;
                    left++;
                    right--;
                }
            }
            flag=!flag;
        }
        return root;
    }
}