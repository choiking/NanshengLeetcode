//https://en.wikipedia.org/wiki/Topological_sorting

//dfs implementation of topo sort
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

//traditional BFS indegree toposort

public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];// i - j, matrix[i][j] = 1
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            if (matrix[pre][post] == 0) {
                 indegree[post]++;
            }
            matrix[pre][post] = 1;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<> ();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] == 1) {
                    if (--indegree[i] == 0)
                        q.offer(i);
                }
            }
        }
        return count == numCourses;
    }
