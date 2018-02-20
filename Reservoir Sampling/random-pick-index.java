/*
    it is like a k = 1 version of Random Pick Index
    */
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (random.nextInt(++count) == 0)
                res = i;// 1 / i的概率保留 i
        }
        return res;
    }