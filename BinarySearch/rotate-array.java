public class Solution {// 3 steps in place O(n) time 
    public void rotate(int[] nums, int k) {
            k = k % nums.length;
        
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length -1);
    }
    public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = temp;
    }
}
}

public class Solution {// O(n) time, O(n) extra place
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
