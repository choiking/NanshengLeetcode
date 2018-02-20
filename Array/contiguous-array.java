public static int findMaxLength(int[] nums) {
    //PreSum[j] - PreSum[i] = 0 = Sum(nums[i + 1], nums[i + 2], …, nums[j])
        Map<Integer, Integer> preSum = new HashMap<> ();
        preSum.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (preSum.containsKey(sum)) {
                max = Math.max(max, i - preSum.get(sum));
            }
            else {
                preSum.put(sum, i);
            }
        }
        return max;
    }