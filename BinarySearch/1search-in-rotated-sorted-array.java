public class Solution {
    public int search(int[] array, int num) {
         if (array == null || array.length == 0) {
	            return -1;
	        }
	
	        int pivot = findPivot(array);
	        if (pivot > 0 && num >= array[0] && num <= array[pivot - 1]) {
	            return binarySearch(array, 0, pivot - 1, num);
	        } else {
	            return binarySearch(array, pivot, array.length - 1, num);
	        }
	    }
	    
	    public static int findPivot(int[] array) {
	
	        if (array == null || array.length == 0) {
	            return -1;
	        }
	
	        if (array.length == 1 || array[0] < array[array.length - 1]) {
	            return 0;
	        }
	
	        int start = 0, end = array.length - 1;
	
	        while (start <= end) {
	
	            int mid = (start + end) / 2;
	             
	            if ( array[mid] > array[mid + 1]) {
	                return mid + 1;
           } else if (array[start] <= array[mid]) {
	                start = mid + 1;
	            } else {
               end = mid - 1;
	            }
	        }
	
	        return 0;
	    }
	    
	    public static int binarySearch(int[] array, int start, int end, int num) {
	        
	        if (array == null || array.length == 0) {
	            return -1;
	        }
	        
	        if(start > end || start < 0 || end >= array.length) {
	            throw new IllegalArgumentException("Invalid values for start and end! start = "  + start + ", end = "  + end);
	        }
	
	        if(num < array[start] || num > array[end]) {
	            return -1;
	        }
	        
	        while (start <= end) {
	
	            int mid = (start + end) / 2;
	            if (array[mid] == num) {
	                return mid;
	            } else if (num < array[mid]) {
               end = mid - 1;
           } else {
               start = mid + 1;
           }
       }
       return -1;
	    }
    }
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