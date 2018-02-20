/*
  Brute Force 

  From Empty to Gate

  time : O(mn * mn)
  space : O (mn)
*/


private static final int EMPTY = Integer.MAX_VALUE;
private static final int GATE = 0;
private static final int WALL = -1;
private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},//go south
        new int[] {-1,  0},//go north
        new int[] { 0,  1},//go east
        new int[] { 0, -1}//go west
);

public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0) return;
    for (int row = 0; row < rooms.length; row++) {
        for (int col = 0; col < rooms[0].length; col++) {
            if (rooms[row][col] == EMPTY) {
                rooms[row][col] = distanceToNearestGate(rooms, row, col);
            }
        }
    }
}

private int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
    int m = rooms.length;
    int n = rooms[0].length;
    int[][] distance = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { startRow, startCol });
    while (!q.isEmpty()) {
        int[] point = q.poll();
        //begin point
        int row = point[0];
        int col = point[1];
        for (int[] direction : DIRECTIONS) {
            //direction
            int r = row + direction[0];
            int c = col + direction[1];
            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == WALL
                    || distance[r][c] != 0) {//distance[r][c] != 0 避免重合点
                continue;
            }
            distance[r][c] = distance[row][col] + 1;
            if (rooms[r][c] == GATE) {
                return distance[r][c];
            }
            q.add(new int[] { r, c });
        }
    }
    return Integer.MAX_VALUE;
}
/*
we initiate breadth-first search (BFS) from all gates at the same time. 
Since BFS guarantees that we search all rooms of distance d before searching 
rooms of distance d + 1, the distance to an empty room must be the shortest.

From Gate to Empty.

time : O(mn)
space : O(mn)
*/




private static final int EMPTY = Integer.MAX_VALUE;
private static final int GATE = 0;
private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}
);

public void wallsAndGates(int[][] rooms) {
    int m = rooms.length;
    if (m == 0) return;
    int n = rooms[0].length;
    Queue<int[]> q = new LinkedList<>();
    for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            if (rooms[row][col] == GATE) {
                q.add(new int[] { row, col });
            }
        }
    }
    while (!q.isEmpty()) {
        int[] point = q.poll();
        int row = point[0];
        int col = point[1];
        for (int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                continue;
            }
            //it must be a EMPTY room now
            rooms[r][c] = rooms[row][col] + 1;
            q.add(new int[] { r, c });
        }
    }
}






/*
shortest and Easiest understanding DFS solution

From Gate to Empty

*/





    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) 
                    dfs(rooms, i, j, 0);
    }

    private void dfs(int[][] rooms, int i, int j, int d) {
        /*
        rooms[i][j] < d could be a wall (-1 < d)
        or it is more than the existing distance(重合点。。)
        */
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) 
            return;
        rooms[i][j] = d;
        dfs(rooms, i - 1, j, d + 1);
        dfs(rooms, i + 1, j, d + 1);
        dfs(rooms, i, j - 1, d + 1);
        dfs(rooms, i, j + 1, d + 1);
    }




