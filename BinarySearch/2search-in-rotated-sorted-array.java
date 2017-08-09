public class Solution {
      
    public int search(int[] nums, int target) {
      //without finding the pivot
       if(nums == null || nums.length == 0) return -1; 
       int lo = 0, hi = nums.length - 1;
       while(lo + 1 < hi){
           int mid = lo + (hi - lo) / 2;
           if(nums[mid] == target) return mid;
           else if(nums[lo] < nums[mid]){
               if(nums[lo] <= target && nums[mid] > target) {
                   hi = mid; 
               }
               else {
                   lo = mid;
               }
           }
           else {
               if(nums[mid] < target && nums[hi] >= target) {
                   lo = mid; 
               }
               else {
                   hi = mid;
               }
           }
       }
        if(nums[lo] == target) return lo;
        else if(nums[hi] == target) return hi;
        else return -1;
    
}
}