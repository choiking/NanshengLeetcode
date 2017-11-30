class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<> ();
        dfs(res, new ArrayList(), candidates, target, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int pos) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<> (tempList));
        }
        for (int i = pos; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            dfs(res, tempList, candidates, target - candidates[i], i);// not use i + 1 because we can reuse the same num
            tempList.remove(tempList.size() - 1);
        }
    }
}