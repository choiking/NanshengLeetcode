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
}