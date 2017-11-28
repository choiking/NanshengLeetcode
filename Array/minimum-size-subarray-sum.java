class Solution {
    //using map, brute force, time limited exceed O(n * n)
//     public int minSubArrayLen(int s, int[] nums) {
//         int sum = 0, min = Integer.MAX_VALUE;
//         Map<Integer, Integer> map = new HashMap<> ();
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];      
//             if (sum >= s) {
//                 min = Math.min(min, i + 1);
//             }
//             for (int key : map.keySet()) {//O(n)
//                 if (key <= sum - s) {
//                     min = Math.min(min, i - map.get(key));
//                 }
//             }
        
//             if (!map.containsKey(sum)) {
//                 map.put(sum, i);
//             }
//         }
//         return min == Integer.MAX_VALUE ? 0 : min;
//     }
    //better Brute Force O(n * n)
//     public int minSubArrayLen(int s, int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
//         int min = Integer.MAX_VALUE;
//         int[] sum = new int[nums.length];
//         sum[0] = nums[0];
//         for (int i = 1; i < nums.length; i++) {//preprocessing the sum
//             sum[i] = sum[i - 1] + nums[i];//calculate all the sum begin from index of 0
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i; j < nums.length; j++) {
//                 if (sum[j] - sum[i] + nums[i] >= s) {
//                     min = Math.min(min, j - i + 1);
//                     break;
//                 }
//             }
//         }
//         return min == Integer.MAX_VALUE ? 0 : min;
//     }
    //two pointer: Given an array of n POSITIVE!!!! integers and a positive integer s
    //O (2n) running time, both left and right will pass the array once
//     public int minSubArrayLen(int s, int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
//         int min = Integer.MAX_VALUE, left = 0, right = 0, sum = 0;
        
//         while (right < nums.length) {
//             sum += nums[right++];
//             while (sum >= s) {//iterate from left position to right
//                 min = Math.min(min, right - left);
//                 sum -= nums[left++];
//             }
//         }
        
//         return min == Integer.MAX_VALUE ? 0 : min;
//     }
    
    //first calculate cumulative sum and then for each starting point binary search for end position. This uses O(N) space
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;

        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);

        for (int i = 0; i < nums.length; i++) {
            int j = findWindowEnd(i, sums, s);
            if (j == nums.length) break;
            min = Math.min(j - i + 1, min);
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int findWindowEnd(int lo, int[] sums, int s) {//find Window End using Binary Search
        int hi = sums.length - 1, offset = lo == 0 ? 0 : sums[lo - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = sums[mid] - offset;
            if (sum >= s) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
   }
    
    
    
    
    
    
    
    
    
}