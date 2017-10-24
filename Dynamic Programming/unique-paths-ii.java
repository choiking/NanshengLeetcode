class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid == null 
            || obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    res[i][j] = 1;
                }
                else if (i == 0) {
                    res[i][j] = res[i][j - 1];
                }
                else if (j == 0) {
                    res[i][j] = res[i - 1][j];
                }
                else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[row - 1][col - 1];
    }
}