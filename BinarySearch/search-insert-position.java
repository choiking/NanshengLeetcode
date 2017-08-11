public class Solution {
    public int searchInsert(int[] nums, int target) {
       if(nums.length==0||nums[0]>target) return 0;
        int i=0;
        while(i<nums.length){
          if(nums[i]>=target) return i; 
          else{
              if(i==nums.length-1) return i+1;
              i++;
          }
       }
        return nums.length;
    }
}