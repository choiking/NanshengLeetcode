class Solution {
    int count;
    public int totalNQueens(int n) {
        dfs(new int[n], 0, n);
        return count;
    }
    private void dfs(int[] pos, int colIndex, int n) {
        if (colIndex == n) {
            count++;
            return;
        }
        //pos record the location of all Queens
        for (int i = 0; i < n; i++) {
            pos[colIndex] = i;
            if (check(pos, colIndex)) {
                dfs(pos, colIndex + 1, n);
            }
        }

    }

    private boolean check(int[] pos, int colIndex) {
        for (int i = 0; i < colIndex; i++) {
            if (pos[i] == pos[colIndex] || Math.abs(pos[i] - pos[colIndex]) == Math.abs(i - colIndex))
                return false;
        }
        return true;
    }
}
