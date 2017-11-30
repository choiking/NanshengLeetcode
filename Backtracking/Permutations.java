class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Arrays.sort(nums);// make it easy to skip
        dfs(result, new ArrayList<>(), nums);
        return result;
    }
    void dfs(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {           //(去掉pos是因为在排列组合中[1,2,3]和[3,2,1]都是答案）
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
