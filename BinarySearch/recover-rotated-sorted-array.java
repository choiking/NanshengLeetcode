public class Solution {
    /*
     * @param nums: An integer
     * @return: 
     */
    //三步翻转法
    public void recoverRotatedSortedArray(List<Integer> nums) {
        int i = 0;
        while(i < nums.size() - 1) {
           if(nums.get(i) > nums.get(i + 1)){
             reverse(nums, 0, i);
             reverse(nums, i + 1, nums.size() - 1);
             reverse(nums, 0, nums.size() - 1);
           }
           else{
           	i++;
           }
        }
       
    }
     public void reverse(List<Integer> nums, int start, int end) {
      for (int i = start, j = end; i < j; i++, j--) {
      	int temp = nums.get(i);
      	nums.set(i, nums.get(j));
      	nums.set(j, temp);
      }

     }
	
	       
};