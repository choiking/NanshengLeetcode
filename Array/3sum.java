class Solution {
    /*
    brute force
    O(n 4)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<> (Arrays.asList(nums[i], nums[j], nums[k]));
                        if (!res.contains(list))//O(n) time complexity
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    /*
     two pointer
     O(n2)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<> ();
        if (size < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int start = 0; start < size - 2; start++) {
            if (start == 0 || nums[start] != nums[start - 1]) {//skip the same
                int lo = start + 1, hi = size - 1;
                while (lo < hi) {
                    int sum = nums[start] + nums[lo] + nums[hi];
                    if (sum < 0) {
                        lo++;
                    }
                    else if (sum > 0) {
                        hi--;
                    }
                    else {
                        List<Integer> list = new ArrayList<> (Arrays.asList(nums[start], nums[lo], nums[hi]));
                        res.add(list);
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;//skip the same
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;//skip the same
                        lo++;
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    //用Set排除duplicate，前提是先排序好

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        Set<List<Integer>> set = new HashSet<> ();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = new ArrayList<> ();
                if (map.containsKey(-nums[i]-nums[j]) && map.get(-nums[i]-nums[j]) > j) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[map.get(-nums[i]-nums[j])]);
                    if (set.add(list))  res.add(list);
                }
            }
        }
        return res;
    }
}
