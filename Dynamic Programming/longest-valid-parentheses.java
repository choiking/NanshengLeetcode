class Solution {
    /*
    The main idea is as follows: I construct a array longest[], for any longest[i], it stores the longest length of valid       parentheses end at i.

    And the DP idea is :

    If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.

    Else if s[i] is ')'

        If s[i-1] is '(', longest[i] = longest[i-2] + 2

        Else if s[i-1] is ')' and s.charAt(i-longest[i-1] - 1) == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

    For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6.
    */
    public int longestValidParentheses(String s) {
        int len = s.length(), curMax = 0;
        if (len <= 1) return 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {//  ()(()
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    curMax = Math.max(dp[i],curMax);
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    /*0 1 2   3 4 5
                      ( ) (   ( ) ) i = 5
                      4 - dp[4] = 4 - 2 = 2

                      0 1   2 3 4 5
                      ( )   ( ( ) ) i = 5
                    */
                    dp[i] = dp[i - 1] + 2 + (i - (2 + dp[i - 1]) >= 0 ? dp[i - (2 + dp[i - 1])] : 0);
                    curMax = Math.max(dp[i],curMax);
                }
            }
        }
        return curMax;

    }


}
