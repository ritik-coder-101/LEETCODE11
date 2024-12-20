// 2641. Cousins in Binary Tree II - {M}
// Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.

// Two nodes of a binary tree are cousins if they have the same depth with different parents.

// Return the root of the modified tree.

// Note that the depth of a node is the number of edges in the path from the root node to it.

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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        List<Integer> list=new ArrayList<>();

        while (!que.isEmpty()) {
            int size=que.size();
            int sum=0;

            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();
                sum+=node.val;
                if (node.left != null ) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            list.add(sum);
        }

        que.offer(root);
        root.val=0;
        int l=0;

        while (!que.isEmpty()) {
            int size=que.size();
            int lvls=(l+1< list.size() ? list.get(l+1) : 0 );

            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();
                int childs=0;

                if (node.left != null) {
                    que.offer(node.left);
                    childs+=node.left.val;
                }

                if (node.right != null) {
                    que.offer(node.right);
                    childs+=node.right.val;
                }

                if (node.left != null) node.left.val=lvls-childs;
                if (node.right != null) node.right.val = lvls -childs;
            }
            l++;
        }
        return root;
    }
}