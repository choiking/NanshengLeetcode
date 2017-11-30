/*
generally two ways to traversal tree:

1. DFS
2. BFS(using queue):







*/

 public final String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<> ();
        if (digits.length() == 0) return res;
        dfs(res, digits, "", 0);
        return res;
    }
    public void dfs(List<String> res, String digits, String tempStr, int pos) {
        if (tempStr.length() == digits.length()) {//退出条件
            res.add(tempStr);
            return;
        }
        String letters = keys[digits.charAt(pos) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            tempStr += letters.charAt(i);
            dfs(res, digits, tempStr, pos + 1);
            tempStr = tempStr.substring(0, tempStr.length() - 1);//delete the last character
        }
    }