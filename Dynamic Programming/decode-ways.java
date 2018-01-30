// I then check one digit and two digit combination and save the results along the way.
public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        if (s.charAt(0) != '0') dp[0] = 1;
        else return 0;
        
        for (int i = 1; i < s.length(); i++) {
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            if (first != 0) {
                dp[i] = dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                if (i == 1) 
                    dp[i]++;
                else
                    dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }