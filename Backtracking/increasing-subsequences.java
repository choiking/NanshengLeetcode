class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<> ();
        if (nums == null || nums.length == 0) return res;
        Set<LinkedList<Integer>> set = new HashSet<> ();
        helper(nums, 0, res, new LinkedList<> (), set);
        return res;
    }


    void helper(int[] nums, int pos, List<List<Integer>> res, LinkedList<Integer> list, Set<LinkedList<Integer>> set) {
        if (!set.contains(list) && list.size() >= 2) {
            res.add(new LinkedList<> (list));//remember just add copy of list
            set.add(new LinkedList<> (list));//remember just add copy of list
        }
        for (int i = pos; i < nums.length; i++) {
            if (list.isEmpty() || list.getLast() <= nums[i]) {
                list.add(nums[i]);
                helper(nums, i + 1, res, list, set);
                list.removeLast();
            }
        }
    }
}
