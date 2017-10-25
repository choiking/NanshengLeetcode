public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        /*
        if (match)
        LCS = LCS((m-1) + (n - 1)) + 1;
        else
        LCS = Max(LCS((m) + (n - 1)), LCS((m - 1) + (n))
        
        
        */
        if (A == null || B == null) return 0;
        int lenA = A.length(), lenB = B.length();
        // The following is recursive way which will end up 2 ^ n running time
        // if (lenA == 0 || lenB == 0) return 0;
        // if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
        //     return longestCommonSubsequence(A.substring(0, lenA - 1), 
        //     B.substring(0, lenB - 1)) + 1;
        // }
        // else {
        //     return Math.max(longestCommonSubsequence(A.substring(0, lenA - 1), 
        //     B), longestCommonSubsequence(A, 
        //     B.substring(0, lenB - 1)));
        // }
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[lenA][lenB];
    }
}