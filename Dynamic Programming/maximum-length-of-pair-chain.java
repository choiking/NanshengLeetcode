class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0 || pairs == null) return 0;
        int row = pairs.length;
        int[] dp = new int[row];
        Arrays.sort(pairs, (a,b) -> (a[0] - b[0]));
        Arrays.fill(dp, 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }
        return dp[row - 1];
    }
}