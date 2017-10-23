class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);// make it easy to skip
        boolean[] visited = new boolean[nums.length];
        dfs(result, new ArrayList<>(), nums, visited);
        return result;
    }
    void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]||(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
            continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(result, list, nums,visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
    }

