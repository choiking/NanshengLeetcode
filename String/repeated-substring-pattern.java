class Solution {
    /*
      a b c a b c a b c
      0 0 0 1 2 3 4 5 6
    lenOfPrefix = 9 - 6 = 3;
    9 % 3 == 0; it is!
    
     a b c d a b c
     0 0 0 0 1 2 3
     lenOfPrefix = 7 - 3 = 4;
     7 % 4 != 0; it is NOT!
    */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int lenOfPrefix = n - lps(s)[n - 1];
        return lps(s)[n - 1] > 0 && n % lenOfPrefix == 0;
    }
    
    
    //construct a lps(longest prefix of the string which is also the suffix of it) int array
    /* a b c d a b c f g
       0 0 0 0 1 2 3 0 0
         0 in b means for ab, lps is 0;
         3 in c means for abcdabc, lps is 3;
         0 in g means for abcdabcfg, lps is 0.
    */
    private int[] lps(String s) {
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int i = 0, j = 1;
        while (i < s.length() && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            }
            else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                }
                else {
                    i = lps[i - 1];
                }
            }
        }
        return lps;
    }
}