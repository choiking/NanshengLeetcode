/*

Dijkstra's

shortest path from one node to all node


Bellan-Ford

shortest path from one node to all node including negative edges


Floyd-Warshall

shortest path between all pairs of vertices, negative edges allowed



let dist[i][j] be a array of minimum distances between i and j (initialized to max value)

procedure FloydWarshallWithPathReconstruction ()
   for each edge (u,v)
      dist[u][v] ← w(u,v)  // the weight of the edge (u,v)
   for k from 1 to |V| // standard Floyd-Warshall implementation
      for i from 1 to |V|
         for j from 1 to |V|
            if dist[i][j] > dist[i][k] + dist[k][j] then
               dist[i][j] ← dist[i][k] + dist[k][j]
            end if

*/


class Solution {
    /*Image a/b = k as a link between node a and b, the weight from a to b is k, the reverse
    link is 1/k. Query is to find a path between two nodes.

    (A/B)*(B/C)*(C/D) is like the path A->B->C->D = A / D = dist(A,B) * dist(B,C) * dist(C,D)
    */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<> ();// <a, <b, distance between a and b>>

        for (int i = 0; i < equations.length; i++) {
            map.putIfAbsent(equations[i][0], new HashMap<> ());
            map.putIfAbsent(equations[i][1], new HashMap<> ());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }

        double[] responses = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            responses[i] = dfs(queries[i][0], queries[i][1], 1, map, new HashSet<> ());
        }

        return responses;

    }
    //find the shortest from s to t.
    double dfs(String s, String t, double r, Map<String, Map<String, Double>> map, Set<String> seen) {
        if (!map.containsKey(s)) return -1;
        seen.add(s);
        if (s.equals(t)) return r;
        Map<String, Double> next = map.get(s);
        for (String c : next.keySet()) {
            double result = 0;
            if (!seen.contains(c))
                //(A/B)*(B/C)*(C/D) is like the path A->B->C->D = A / D = dist(A,B) * dist(B,C) * dist(C,D)
                result = dfs(c, t, r * next.get(c), map, seen);
            else
                result = -1;
            if (result != -1) return result;
        }
        return -1;
    }
}
