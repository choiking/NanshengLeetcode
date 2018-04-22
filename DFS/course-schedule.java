class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      //Create a adjacency list representation of Graph
      List<Integer>[] adj = new ArrayList [numCourses];
      for (int i = 0; i < numCourses; i++) {
          adj[i] = new ArrayList<> ();
      }
      for (int[] arr : prerequisites) {
          adj[arr[1]].add(arr[0]);
      }
      boolean[] visited = new boolean[numCourses];//vertices has visited
      //do a DFS to detect if cycle exists
      //start from all the vertices because in case some vertices outdegree = 0;
      for (int i = 0; i < numCourses; i++) {
          if (!dfs(adj, visited, i))
              return false;
      }
      return true;
  }

  boolean dfs(List<Integer>[] adj, boolean[] visited, int v) {
      if (visited[v]) return false;
      visited[v] = true;
      for (int w : adj[v]) {
          if (!dfs(adj, visited, w))
              return false;
      }
      visited[v] = false;//have been used, make it false for next use.
      return true;
  }
}
