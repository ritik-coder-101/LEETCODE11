// 1976. Number of Ways to Arrive at Destination -{M}

// You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

// You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

// Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7

class Solution {

    int MOD=1_000_000_007;

    class duo{
        int vertex;
        long count;

        duo(int vertex,long count) {
            this.vertex=vertex;
            this.count=count;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<duo>> list=new ArrayList<>();

        for (int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }

        for (int[] i : roads) {
            list.get(i[0]).add(new duo(i[1],i[2]));
            list.get(i[1]).add(new duo(i[0],i[2]));
        }

        long[] dis=new long[n];
        long[] ways=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);

        PriorityQueue<duo> pq=new PriorityQueue<>((a,b) -> Long.compare(a.count,b.count));
        pq.offer(new duo(0,0));
        dis[0]=0;
        ways[0]=1;

        while (!pq.isEmpty()) {
            duo d=pq.poll();
            int v=d.vertex;
            long c=d.count;

            if (c > dis[v] ) continue;

            for (duo i : list.get(v)) {
                long nc=c+i.count;
                if (nc < dis[i.vertex]) {
                    dis[i.vertex]=nc;
                    ways[i.vertex]=ways[v];
                    pq.offer(new duo(i.vertex,nc));
                } else if (nc == dis[i.vertex]) {
                    ways[i.vertex] =(ways[v]+ways[i.vertex])%MOD;
                }
            } 
        }
        return (int) ways[n-1];
    }
}