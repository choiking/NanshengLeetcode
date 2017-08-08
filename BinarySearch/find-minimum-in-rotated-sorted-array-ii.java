public class Solution {
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;
        //只考虑hi和mid的情况，就不像lo和mid需要考虑中间的反转，比较省事。
        while(lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            
            if (num[hi] > num[mid]) {
                hi = mid;
            }
            else if (num[hi] < num[mid]) {
                lo = mid;
            }
            else { // when num[mid] and num[hi] are same, move hi and mid.
                hi--;
            }
        }
        
        if(num[lo] < num[hi]) return num[lo];
        return num[hi];
	    }
	    
}
