/*
只能倒着找结果，正向求的话会遇到 "aaaaaaa"   ["aaaa","aaa"]
AaaAaaA 的结果。
倒着找，可以回溯以前的解：  AaaAaaA A

*/


public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String str: wordDict) {
                if (str.length() <= i && f[i - str.length()] && s.substring(i-str.length(), i).equals(str)) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[len];
    }
    
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (wordDict.contains(s.substring(j, i)) && res[j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}