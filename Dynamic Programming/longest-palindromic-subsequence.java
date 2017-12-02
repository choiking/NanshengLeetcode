class Solution {
    /*
    REMEMBER: Subsequence is different from Substring, Substring has to be contigous, but 
    Subsequence doesn't necessarily to.
    suppose s.length() = 7;
    if (s.charAt(0) == s.charAt(6)) {
        lps = 2 + lps(0, 5);
    }
    else {
        lps = Math.max(lps(0,5), lps(1,6));
    }  
      b b b a b
    b 1 2 3 3 4
    b   1 2 2 3
    b     1 1 4
    a       1 1
    b         1
    
    */

    public int longestPalindromeSubseq(String s) {
        int len = s.length(), j = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int currLen = 2; currLen <= len; currLen++) {
            for (int i = 0; i <= len - currLen; i++) {
                j = i + currLen - 1;
                if (s.charAt(i) == s.charAt(j) && currLen == 2) {
                    dp[i][j] = 2;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
    
    
}