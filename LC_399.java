// 399. Evaluate Division - {M}

// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
// Return the answers to all queries. If a single answer cannot be determined, return -1.0.
// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
// Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

class LC_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map=new HashMap<>();

        for (int i=0;i<equations.size();i++) {
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);

            double v=values[i];

            map.putIfAbsent(a,new HashMap<>());
            map.putIfAbsent(b,new HashMap<>());

            map.get(a).put(b,v);
            map.get(b).put(a,1.0/v);
        }

        double[] res=new double[queries.size()];

        for (int i=0;i<queries.size();i++) {
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);

            if (!map.containsKey(a) || !map.containsKey(b)) res[i]=-1.0;
            else {
                Set<String> set=new HashSet<>();
                res[i]=dfs(map,a,b,1.0,set);
            }
        }
        return res;
    }

    private double dfs(Map<String,Map<String,Double>> map,String curr,String tar,double val,Set<String> set) {
        if (curr.equals(tar)) return val;

        set.add(curr);

        Map<String,Double> gar=map.get(curr);

        for (String a : gar.keySet()) {
            if (!set.contains(a)) {
                double v=dfs(map,a,tar,val*gar.get(a),set);

                if (v != -1.0) return v;
            }
        }

        return -1.0;
    }
}