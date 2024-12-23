// 2471. Minimum Number of Operations to Sort a Binary Tree by Level -{M}
// You are given the root of a binary tree with unique values.

// In one operation, you can choose any two nodes at the same level and swap their values.

// Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.

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
    public int minimumOperations(TreeNode root) {
        if (root== null) return 0;

        int count=0;

        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size=que.size();
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode node=que.poll();

                list.add(node.val);

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            count+=swap(list);
        }
        return count;   
    }

    private int swap(List<Integer> list){
        int l=list.size();
        List<Integer> sortl=new ArrayList<>(list);
        Collections.sort(sortl);
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<l;i++) {
            map.put(list.get(i),i);
        }

        int swaps=0;

        for (int i=0;i<l;i++) {
            if (!list.get(i).equals(sortl.get(i))) {
                int index=map.get(sortl.get(i));
                map.put(list.get(i),index);
                map.put(list.get(index),i);
                Collections.swap(list,i,index);
                swaps++;
            }
        }
        return swaps;
    }
}