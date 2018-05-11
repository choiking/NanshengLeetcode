class Solution {
    /*
    (1, 2, 3) target = 4;
    dp[4] = dp[4 - 1] + dp[4 - 2] + dp[4 - 3];
    dp[4] = dp[3] + dp[2] + dp[1];
    */
    //Top down DP solution
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];//dp[i] means result for target = i;
        Arrays.fill(dp, -1);
    only happens when in the previous call, target = nums[i]
        dp[0] = 1;//return 1;
        return helper(nums, target);
    }
    int helper(int[] nums, int target) {
    //We can fill the array with -1 to indicate that the result hasn’t been calculated yet.
        if (dp[target] != -1)
            return dp[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += helper(nums, target - nums[i]);
        }
        dp[target] = res;
        return dp[target];
        
    }
    /*
    dp[4] = dp[3] + dp[2] + dp[1];
    dp[3] = dp[2] + dp[1] + dp[0];
    .....
    */
    //Bottom up DP solution
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        int[] com = new int[target + 1];
        com[0] = 1;
        for (int i = 1; i < com.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    com[i] += com[i - nums[j]];
            }
        }
        return com[target];
    }
}
