class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<> ();
        dfs(res, new ArrayList(), n, k, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> tempList, int n, int k, int pos) {
        if (tempList.size() == k) {
            res.add(new ArrayList<> (tempList));
            return;
        }
        for (int i = pos; i <= n; i++) {
            tempList.add(i);
            dfs(res, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}