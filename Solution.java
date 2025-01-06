// 787. Cheapest Flights Within K Stops -{M}

// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

public class Solution {

    class Pair{
        int vertex,weight,stop;
        Pair(int vertex,int weight,int stop) {
            this.vertex=vertex;
            this.weight=weight;
            this.stop=stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();

        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i: flights) {
            adj.get(i[0]).add(new Pair(i[1],i[2],0));
        }

        int[][] dist=new int[n][k+2];
        for (int[] i : dist) {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.offer(new Pair(src,0,0));
        dist[src][0]=0;

        while (!pq.isEmpty()) {
            Pair collect=pq.poll();
            int v=collect.vertex;
            int w=collect.weight;
            int stop=collect.stop;

            if (v == dst) return w;

            if (stop > k ) continue;

            for (Pair p : adj.get(v)) {
                int nv=p.vertex;
                int nw=p.weight+w;

                if (nw < dist[nv][stop+1]) {
                    dist[nv][stop+1]=nw;
                    pq.offer(new Pair(nv,nw,stop+1));
                }
            }
        }
        return -1;
    }
} {
    
}
