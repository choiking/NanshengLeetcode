public class Solution {
    public int findMin(int[] array) {
        if (array == null || array.length == 0) return -1;
	
	    if (array.length == 1 || array[0] < array[array.length - 1]) {
	            return array[0];
	        }
	       
	        int start = 0, end = array.length - 1;
	
	        while (start <= end) {
	
	            int mid = (start + end) / 2;
	             
	            if ( array[mid] > array[mid + 1]) {
	                return array[mid + 1];
           } else if (array[start] <= array[mid]) {
	                start = mid + 1;
	            } else {
               end = mid - 1;
	            }
	        }
	
	        return array[0];
	    }
	    
    }
