class Solution {
    //time: O(n^2)
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        Arrays.fill(lengths, 1);
        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                    }
                }
            }
        }

        int longest = 1;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        return longest;
    }
    //time: O (nlogn)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            //find the insertion point,to replace bigger point
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);//when not found, i = -insertionPoint - 1, get the insertion point
            }
            
            dp[i] = num;
            if (i == len) {//if insert in the tail of array
                len++;//then increase len of dp array
            }
        }
        return len;
    }
}