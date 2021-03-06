class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void dfs(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int counter = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) counter++;
            if (s.charAt(i) == par[1]) counter--;
            if (stack == -1) {//现在刚好多了一个 ')'， remove it!
                for (int j = last_j; j <= i; j++) {
                    //j == last_j || s.charAt(j - 1) != par[1] means we choose to remove the first ')'!
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                        //recursively remove j from pos of i and j.
                        dfs(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            dfs(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}