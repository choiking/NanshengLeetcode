class Solution {
    private int lo = 0, maxLen = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        for (int i = 0; i < len; i++) {
            extendAroundCenter(s, i, i);//odd length
            extendAroundCenter(s, i, i + 1);//even length
        }
        return s.substring(lo, lo + maxLen);
    }
    public void extendAroundCenter(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}

/*  
 1.倒着写
    b a b a d
  b 1 0 1 0 0
  a   1 0 1 0 
  b     1 0 0
  a       1 0
  d         1  从下往上一层一层写。
  只能倒着找结果，正向求的话会遇到 
Input:
"aaaa"
Output:
"aaa"
Expected:
"aaaa"
  倒着找，可以回溯以前的解。


  2.或者正向， 通过currLen 长度查找。
*/




class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}


class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size == 0) return "";
        int palinBeginAt = 0, maxLen = 1;
        boolean[][] palin = new boolean[size][size];
        //single letter always true
        for (int i = 0; i < size; i++) {
            palin[i][i] = true;
        }
        //two letters
        for (int i = 0; i < size - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palin[i][i + 1] = true;
                palinBeginAt = i;
                maxLen = 2;
            }
        }
        //finding palin from 3 to n (currLen)
        for (int currLen = 3; currLen <= size; currLen++) {
            for (int i = 0; i <= size - currLen; i++) {
                int j = i + currLen - 1;
                if (s.charAt(i) == s.charAt(j) && palin[i + 1][j - 1]) {
                    palin[i][j] = true;
                    palinBeginAt = i;
                    maxLen = currLen;
                }
            }
        }
        return s.substring(palinBeginAt, maxLen + palinBeginAt);
    }
}

