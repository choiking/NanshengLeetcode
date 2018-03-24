class Solution {
    //using set and visited, you can remove duplicate permutation
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<> ();
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<> (), visited, nums);
        List<List<Integer>> result = new ArrayList<> ();
        result.addAll(res);
        return result;
    }

    void dfs(Set<List<Integer>> res, List<Integer> tempList, boolean[] visited, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<> (tempList));// if it duplicate, it will not be added since it is a set
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            tempList.add(nums[i]);
            visited[i] = true;
            dfs(res, tempList, visited, nums);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }

    //just using visited
    //deal with duplicates;in the same position, only put one distinct number once.
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);//better to find the duplicate one
        dfs(res, new ArrayList<> (), visited, nums, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tempList, boolean[] visited, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<> (tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) continue;//deal with duplicates;
            tempList.add(nums[i]);
            visited[i] = true;
            dfs(res, tempList, visited, nums);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }

}
