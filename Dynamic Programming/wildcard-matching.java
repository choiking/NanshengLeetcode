public boolean isMatch(String s, String p) {
      int len1 = s.length(), len2 = p.length();
      boolean[][] dp = new boolean[len1 + 1][len2 + 1];//matches[i][j] = true if s.substring(0, i - 1) match p.substring(0, j - 1)
      dp[0][0] = true;
      for (int j = 1; j <= len2; j++) {
          if (p.charAt(j - 1) == '*') {
              dp[0][j] = dp[0][j - 1];
          }
      }

      for (int i = 1; i <= len1; i++) {
          for (int j = 1; j <= len2; j++) {
              if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else if (p.charAt(j - 1) == '*') {
                  // "aa" - "a*" || "a" - "a*"
                  dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
              } else {
                  dp[i][j] = false;
              }
          }
      }


      return dp[len1][len2];
}
