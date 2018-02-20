class Solution {
//     time : 2 ^ n
//     int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    
    void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        }
        else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
    /*
    Recursion with Memorization 
    
    2.The sum of elements in the given array will not exceed 1000.
    so sum range = [-1000, 1000];
    
    */
    public int findTargetSumWays(int[] nums, int S) {
        //ways[i][j + offset] means # of ways to sum up to j using nums[0 ~ i];
        int[][] ways = new int[nums.length][2001];
        for (int[] row : ways)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, ways);
    }
    
    int calculate(int[] nums, int i, int sum, int S, int[][] ways) {
        if (i == nums.length) {
            if (sum == S) 
                return 1;     
            else 
                return 0;
        }
        else {
            if (ways[i][sum + 1000] != Integer.MIN_VALUE) {
                return ways[i][sum + 1000];//already calculate, skip it;
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, ways);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, ways);
            ways[i][sum + 1000] = add + subtract;
            return ways[i][sum + 1000];
        }
    }
    /*
     DP
     time 2000 * n
    */
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;//in case nums[0] == 0
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        //since sum of all elements will not exceed 1000
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}