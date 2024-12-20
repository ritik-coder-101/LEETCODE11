// 46. Permutations -{M}

// Given an array nums of distinct integers, return all the possible 
// permutations
// . You can return the answer in any order.

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];

        back(nums,visited,new ArrayList<>(),res);
        return res;
    }

    private void back(int[] nums,boolean[] visited,List<Integer> path,List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (!visited[i]) {
                visited[i]=true;
                path.add(nums[i]);
                back(nums,visited,path,res);
                path.remove(path.size()-1);
                visited[i]=false;
            }
        }
    }
}