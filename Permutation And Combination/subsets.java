class Solution {//time: 2的n次方
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }
    void dfs(List<List<Integer>> result, List<Integer> templist, int[] nums, int pos) {
        result.add(new ArrayList<> (templist));
        for (int i = pos; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
