class Solution {
    /*
      brute force time limited exceed
      O(n2);
    */
    public int maxArea(int[] height) {
        int size = height.length, max = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int cap = (j - i) * Math.min(height[i], height[j]);
                if (cap > max) {
                    max = cap;
                }
            }
        }
        return max;
    }
    /*
     two pointer
     O(n)
     if if (height[lo] < height[hi]) when ignore (lo, hi - 1), (lo, hi - 2)...
     why we can ignore it?
     because the lo is the max height, and the width of (lo, hi - 1), (lo, hi - 2)...is shorter than (lo, hi);
     so cap of (lo, hi - 1), (lo, hi - 2)...is absoultely less than (lo, hi);
    */
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1, max = 0;
        while (lo < hi) {
            int cap = (hi - lo) * Math.min(height[lo], height[hi]);
            if (cap > max) {
                max = cap;
            }
            if (height[lo] < height[hi]) {
                lo++;
            }
            else {
                hi--;
            }
        }
        return max;
    }
    
    
    
}