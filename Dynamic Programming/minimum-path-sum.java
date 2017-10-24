class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int row = grid.length, col = grid[0].length;
        int[][] minPathSum = new int[row][col];//initialize
        // minPathSum[i][j] means min path sum from grid[0][0] to grid[i][j](status)
        // can only move either down or right 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j==0) {
                    minPathSum[i][j] = grid[i][j];
                }
                else if (j == 0) {
                    minPathSum[i][j] = minPathSum[i - 1][j] + grid[i][j];
                }
                else if (i == 0) {
                    minPathSum[i][j] = minPathSum[i][j - 1] + grid[i][j];
                }
                else {
                    minPathSum[i][j] = Math.min(minPathSum[i][j - 1], minPathSum[i - 1][j]) + grid[i][j];
                }
            }
        }
        return minPathSum[row - 1][col - 1];
    }
}

