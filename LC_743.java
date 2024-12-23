// 743. Network Delay Time -{M}

// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

class Solution {

    class Pair{
        int vertex,weight;
        Pair(int vertex,int weight) {
            this.vertex=vertex;
            this.weight=weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : times) {
            int u=i[0];
            int v=i[1];
            int w=i[2];
            adj.get(u).add(new Pair(v,w));
        }

        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(k,0));
        distance[k]=0;

        while (!pq.isEmpty()) {
            Pair collect=pq.poll();
            int u=collect.vertex;

            for (Pair i : adj.get(u)){
                int adjver=i.vertex;
                int adjweight=i.weight;

                if (distance[u]+adjweight < distance[adjver]) {
                    distance[adjver]=distance[u]+adjweight;
                    pq.offer(new Pair(adjver,distance[adjver]));
                }
            }
        }
        int time=0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            time = Math.max(time, distance[i]);
        }

        return time;
    }
}