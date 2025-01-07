// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance - {M}

// There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

// Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

// Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

class Solution {
    int INF=Integer.MAX_VALUE;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dis=new int[n][n];

        for (int i=0;i<n;i++) {
            Arrays.fill(dis[i],INF);
            dis[i][i]=0;
        }

        for (int [] i : edges) {
            dis[i[0]][i[1]]=i[2];
            dis[i[1]][i[0]]=i[2];
        }

        for (int k=0;k<n;k++) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (dis[i][k] !=INF && dis[k][j] != INF) {
                        dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                    }
                }
            }
        }
        int city=-1;
        int min=INF;

        for (int i=0;i<n;i++) {
            int reach=0;
            for (int j=0;j<n;j++) {
                if (dis[i][j] <= distanceThreshold) reach++;
            }

            if (reach <= min) {
                min=reach;
                city=i;
            }
        }
        return city;
    }
}