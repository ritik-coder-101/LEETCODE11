// 1514. Path with Maximum Probability -{M}

// You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

// Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

// If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

class Solution {
    class duo{
        int vertex;
        double chances;

        duo(int vertex,double chances){
            this.vertex=vertex;
            this.chances=chances;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<duo>> list=new ArrayList<>();

        for (int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(new duo(edges[i][1],succProb[i]));
            list.get(edges[i][1]).add(new duo(edges[i][0], succProb[i]));
        }

        double[] prob=new double[n];
        Arrays.fill(prob,0.0);

        PriorityQueue<duo> pq=new PriorityQueue<>((a,b) -> Double.compare(b.chances ,a.chances));
        pq.offer(new duo(start_node,1.0));

        prob[start_node]=1.0;

        while (!pq.isEmpty()) {
            duo d=pq.poll();
            int v=d.vertex;
            double c=d.chances;

            if (v == end_node) return c;

            for (duo i : list.get(v)) {
                double nc=c*i.chances;

                if (nc > prob[i.vertex]) {
                    prob[i.vertex]=nc;
                    pq.offer(new duo(i.vertex,nc));
                }
            }
        }
        return 0.0;
    }
}