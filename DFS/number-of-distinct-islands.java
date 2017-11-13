class Solution {
    /*
    1: first use injective function (r, c) -> (r * (2 * num_columns) + c);
    We need to convert these tuples to an integer with any injective function (injective just means two different 
    tuples don'tconvert to the same integer.)

    Typically, the function that people might choose is (r, c) -> (r * num_columns + c). This is because they can 
    take that result V and inspect V // num_columns, V % num_columns to reconstruct the answer. Instead of choosing 
    the constant num_columns, we could have chosen any bigger number as well.

    Here, because we are dealing with local coordinates, c >= 0 is not guaranteed: it could be anywhere inside the 
    interval [-num_columns + 1, num_columns - 1]. However, r >= 0 is guaranteed because of how we found the shape 
    (we looked for land from top to bottom, left to right.)
    
    In the end, we chose the function (r, c) -> (r * (2 * num_columns) + c). No two local coordinates will have the same result, which is all we needed.
    */
    int[][] grid;
    boolean[][] visited;//If we don't, we risk getting stuck in an in nite loop.
    Set<Integer> shape;
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        Set<Set<Integer>> shapes = new HashSet<> ();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new HashSet<> ();
                dfs(r, c, r, c);
                if (!shape.isEmpty()) {//avoid collision
                   shapes.add(shape);
                }
                }
            }
        return shapes.size();
    }
    public void dfs(int r, int c, int r0, int c0) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] == 1) {
            visited[r][c] = true;
            shape.add((r - r0) * 2 * grid[0].length + c - c0);
            dfs(r + 1, c, r0, c0);
            dfs(r - 1, c, r0, c0);
            dfs(r, c + 1, r0, c0);
            dfs(r, c - 1, r0, c0);
        }
    }



/*

 2: When we start a depth-first search on the top-left square of some island, the path taken by our depth-first search 
 will be the same if and only if the shape is the same. We can exploit this by recording the path we take as our shape - 
 keeping in mind to record both when we enter and when we exit the function.
   

    */






     int m, n;
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        Set<String> set = new HashSet<> ();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfsMarking(grid, i, j, sb, "start");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    public void dfsMarking(int[][] grid, int i, int j, StringBuilder sb, String dire) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
            grid[i][j] = 0;//because we have mark 0, we don't have to worry about infinite loop
            sb.append(dire);
            dfsMarking(grid, i - 1, j, sb, "u"); // top
            dfsMarking(grid, i + 1, j, sb, "d"); // down
            dfsMarking(grid, i, j - 1, sb, "l"); // left
            dfsMarking(grid, i, j + 1, sb, "r"); // right
            sb.append("end");
        }
    }
      
    
    
    
}