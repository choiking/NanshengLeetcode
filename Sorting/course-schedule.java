class Solution {
    /*
    edge list representation
    [ [0,1], [0,6], [0,8], [1,4], [1,6], [1,9], [2,4], [2,6], [3,4], [3,5],
            [3,8], [4,5], [4,9], [7,8], [7,9] ]
    to Adjacency list representation
    it can finish as long as there are no loops
    */
    public boolean canFinish(int numCourses, int[][] pre) {
        //we have to turn edge list to Adjacency list first
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < pre.length; i++) {
            graph[pre[i][1]].add(pre[i][0]);
        }
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;//there is a loop
        }
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, graph[course].get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}