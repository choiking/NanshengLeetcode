/*
generally two ways to traversal tree:

1. DFS
2. BFS(using queue):







*/

class Solution {
    public final String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<> ();
        if (digits.length() == 0) return res;
        dfs(res, "", digits, 0);
        return res;       
    }
    
    public void dfs(List<String> res, String tempStr, String digits, int pos) {
        if (tempStr.length() == digits.length()) {
            res.add(tempStr);
            return;
        }
        String letter = keys[digits.charAt(pos) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            tempStr += letter.charAt(i);
            dfs(res, tempStr, digits, pos + 1);
            tempStr = tempStr.substring(0, tempStr.length() - 1);
        }
    }
}