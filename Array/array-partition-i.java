public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            //d = 0的时候， 是处于 pair的第一个，所以要向上取整；
            //d = 1的时候， 是处于 pair的第二个，所以要向下取整；
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (arr[i + lim] + 2 - d) % 2;
        }
        return sum;
    }


public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;
}