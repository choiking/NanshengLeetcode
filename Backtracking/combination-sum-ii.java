class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<> ();
        Arrays.sort(candidates);// easy to find duplicate(candidates[i] == candidates[i - 1])
        dfs(res, new ArrayList(), candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int pos) {
        if (target < 0) return;
        if (target == 0) res.add(new ArrayList<> (tempList));
        for (int i = pos; i < candidates.length; i++) {
            if(i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            dfs(res, tempList, candidates, target - candidates[i], i + 1);//i + 1 means we can't reuse the same num
            tempList.remove(tempList.size() - 1);
        }
    }


}
