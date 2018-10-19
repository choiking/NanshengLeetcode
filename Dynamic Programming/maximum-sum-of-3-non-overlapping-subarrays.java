public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[4][n + 1]; ////为 i个集合， 前j点下 的 maxSumOfThreeSubarrays
        int[][] idx = new int[4][n + 1];//为 i个集合， 前j点下， 最后一个元素的starting point
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i];
            preSum[i + 1] += nums[i];
        }

        int[][] id = new int[4][nums.length + 1];
        int max = 0, inId = 0, tmpmax = 0;
        for (int i = 1; i <= 3; i++) {//number of sums(集合)
            for (int j = i * k ; j <= n - (3 - i) * k; j++) {//from 0 to j
                int choice1 = dp[i][j - 1];
                int choice2 = preSum[j] - preSum[j - k] + dp[i - 1][j - k];
                if (choice1 < choice2) {
                    dp[i][j] = choice2;
                    idx[i][j] = j - k + 1;
                } else {
                    dp[i][j] = choice1;
                    idx[i][j] = idx[i][j - 1];
                }
            }
        }

        // gather the results
        int last = idx[3][n];//last one for 3 sums
        int mid = idx[2][last - 1];//last one for 2 sums
        int first = idx[1][mid - 1];//last one for 1 sums

        last--; mid--; first--;

        return new int[] {first, mid, last};
    }
