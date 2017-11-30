class Solution {//dp solution: space O(n) / O(1), time O(n);
    // public int maxSubArray(int[] nums) {
    //     int[] dp = new int[nums.length];//dp[i] means the maximum subarray ending with nums[i];
    //     dp[0] = nums[0];
    //     int max = dp[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         if (dp[i - 1] > 0) {
    //             dp[i] = nums[i] + dp[i - 1];
    //         }
    //         else dp[i] = nums[i];
    //         max = Math.max(max, dp[i]);
    //     }
    //     return max;
    // }
    
    
    
    
    
     /*
        Divide-and-conquer method.
        The maximum summation of subarray can only exists under following conditions:
        1. the maximum summation of subarray exists in left half.
        2. the maximum summation of subarray exists in right half.
        3. the maximum summation of subarray exists crossing the midpoints to left and right. 
        1 and 2 can be reached by using recursive calls to left half and right half of the subarraies. 
        Condition 3 can be found starting from the middle point to the left,
        then starting from the middle point to the right. Then adds up these two parts and return. 

        T(n) = 2*T(n/2) + O(n)
        this program runs in O(nlogn) time
        */
    public int maxSubArray(int[] nums) {
        int max = subArray(nums, 0, nums.length-1);
        return max;
    }

    private int subArray(int[] A, int left, int right){
        if (left == right){
            return A[left];
        }
        int mid = left + (right-left)/2;
        int leftSum = subArray(A, left, mid); //left part of the subarray sum, condition 1
        int rightSum = subArray(A, mid+1, right); //right part of the subarray sum, condition 2
        int middleSum = midSubArray(A, left, mid, right); //cross part of the subarray sum, condition 3
        

        return Math.max(Math.max(leftSum, rightSum), middleSum);//return max of one of them
    }

    private int midSubArray(int[] A, int left, int mid, int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--){
            sum += A[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for (int j = mid + 1; j <= right; j++){
            sum += A[j];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}