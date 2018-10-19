class Solution {
    //分别对left和right 做binary search
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) return res;
        int left = firstGreaterEqual(nums, target);
        if (left == nums.length || nums[left] != target) return res;
        int right = firstGreaterEqual(nums, target + 1) - 1;
        return new int[] {left, right};
    }

    int firstGreaterEqual(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (nums[lo] == target)
            return lo;
        if (nums[hi] < target)
            return hi + 1;
        return hi;
    }
}
