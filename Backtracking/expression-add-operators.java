/*
               1                     12
         /         \           /            \   ....
      1 + 2  1 - 2  1 * 2   12 + 3   12 - 3  12 * 3


      the tricky part is eval - prevNode + prevNode * cur;
    */

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<> ();
        StringBuilder sb = new StringBuilder();
        dfs(res, "", num, target, 0, 0, 0);
        return res;
    }


    private void dfs(List<String> res, String path, String num, int target, int start, long eval, long prevNode) {
        if (start == num.length()) {
            if (eval == target) res.add(path);
            return;
        }
        // dfs call on all numbers starting at position 'start'
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && i != start) break;
            long cur = Long.valueOf(num.substring(start, i + 1));
            int len = path.length();
            if (start == 0) {
                dfs(res, path + cur, num, target, i + 1, cur, cur);
            } else {
                dfs(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                dfs(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                dfs(res, path + "*" + cur, num, target, i + 1, eval - prevNode + prevNode * cur, prevNode * cur);
            }
        }
    }
