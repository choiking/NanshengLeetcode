class Solution {
    /*
    Time Limited Exception
    */
//     public int totalHammingDistance(int[] nums) {
//         if (nums.length < 2) return 0;
//         int count = 0;
//         for (int i = 0; i < nums.length; i++)
//             for (int j = i + 1; j < nums.length; j++)
//                 count += hammingDistance(nums[i], nums[j]);
//         return count;
//     }
    
//     public int hammingDistance(int x, int y) {
//         return Integer.bitCount(x ^ y);
//     }
    /*
    (2,3,4)           0 1 0
                      0 1 1
                      1 0 0 
                     -------
                      2 2 2
    */
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {//for every bit
            int bitCount = 0;
            for (int i = 0;i < n;i++)//for every nums
                bitCount += (nums[i] >> j) & 1;//number of 1
            //compute n 个数中，可以组成的pair中两个数不同的数量有多少
            total += bitCount * (n - bitCount);//number of 1 * number of 0
        }
        return total;
    }
}