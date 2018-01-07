class Solution {
    /*
    Brute Force Solution: time O(n2), space O(1)
    max height in its left part and max height in its right part;
    every bar's volume is equals to Math.min(maxLeft, maxRight) - its height;
    
    */
    public int trap(int[] height) {
        int size = height.length, res = 0;
        for (int i = 0; i < size; i++) {
            int vol = 0, maxLeftHeight = 0, maxRightHeight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeftHeight = Math.max(height[j], maxLeftHeight);
            }
            for (int j = i; j < size; j++) {
                maxRightHeight = Math.max(height[j], maxRightHeight);
            }
            vol = Math.min(maxLeftHeight, maxRightHeight) - height[i];
            res += vol;
        }
        return res;
    }
    /*
      DP(a revised version to brute force solution): time O(n), space O(n)
      because we repeatedly find max height in both sides. So, we can pre-calculate the max height firstly(memo)
      and when we iterate the height, we just need to compare the old max value to the new one.
    */
    public int trap(int[] height) {
        int size = height.length, res = 0;
        
        if (height == null || size == 0) {
            return 0;
        }
        //firstly store the max height(memo)
        int[] maxLeftHeight = new int[size];
        maxLeftHeight[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i]);
        }  
        int[] maxRightHeight = new int[size];
        maxRightHeight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i]);
        }
        //then calculate the res;
        for (int i = 0; i < size; i++) {
            res += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
        }
        return res;
        
    }
    /*
    revised DP 
    time O(n), space O(1)
    1.We iterate forwards as usual, keeping the index of the last maximal height. Let this index be called peak
    2.We iterate backwards until peak, keeping track of the last seen maximum, and subtracting excess rainwater
    */
    public int trap(int[] height) {
        // input validation
        if (height == null || height.length < 3) {
            return 0;
        }
        int size = height.length, currMax = 0, res = 0, peak = 0;
        //firstly find the peak, and add water
        for (int i = 0; i < size; i++) {
            if (currMax < height[i]) {
                currMax = height[i];
                peak = i;
            }
            else {
                res += currMax - height[i];
            }  
        }
        currMax = height[size - 1];
        for (int j = size - 1; j > peak; j--) {
            if (currMax < height[j]) {
                currMax = height[j];
            }
            else {
                res -= height[peak] - currMax;
            }  
        }
        
        return res;
    }
    
    /*
      two pointer
      time O(n), space O(1)
    */
    public int trap(int[] arr) {
        int result = 0, left_max = 0, right_max = 0, lo = 0, hi = arr.length - 1;
          
        while(lo < hi) 
        {
            if(arr[lo] < arr[hi])
            {
                if(arr[lo] > left_max) {
                    left_max = arr[lo];
                }  
                else {
                    result += left_max - arr[lo];
                }
                lo++;
            }
            else
            {
                if(arr[hi] > right_max) {
                    right_max = arr[hi];
                }    
                else {
                    result += right_max - arr[hi];
                }
                hi--;
            }
        }
          
        return result;
    }
    /*another two pointer way (easily understand)
      time O(n), space O(1)
    */
    public int trap(int[] A) {
        // input validation
        if (A == null || A.length < 3) {
            return 0;
        }

        // 2 pointers, sliding window
        int sum = 0, leftMax = 0, rightMax = 0;
        for (int lo = 0, hi = A.length - 1; lo < hi; ) {
            // update leftMax and rightMax
            leftMax  = Math.max(leftMax,  A[lo]);
            rightMax = Math.max(rightMax, A[hi]);
            // fix left side, move right side
            if (leftMax > rightMax) {
                sum += rightMax - A[hi];
                hi--;
            // fix right side, shrink left side
            } else {
                sum += leftMax - A[lo];
                lo++;
            }
        }
        return sum;
    }
     
    
    
}