/*
  产生所有长度 = 2n的组合，一一判断vaild。
  有可能产生 "((" (n = 1)的组合
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}

/*
the main concept is that in a parenthesis balanced string, count of ')' must be less than
equal to count of '(' for every prefix of the string. A parenthesis balanced string (of size 2*N)
must have N number of '(' and N number of ')'. We go on adding '(' before ')' for every recursive
state string until count of '(' becomes equal to N. Then we start adding ')' only on a condition
that count of ')' is less than count of '('. These two conditions will always produce balanced string.

*/

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
