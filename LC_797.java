// 797. All Paths From Source to Target - {M}

// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

// The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();

        list.add(0);

        dfs(graph,0,res,list);

        return res;
    }

    private void dfs(int[][] graph,int node,List<List<Integer>> res,List<Integer> list) {
        if (node ==graph.length-1) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i : graph[node]) {
            list.add(i);
            dfs(graph,i,res,list);
            list.remove(list.size()-1);
        }
    }
}