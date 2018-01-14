class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int lo = 1, hi = x, mid = 1, value = 0;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (mid < x / mid) {//避免超范围的写法。 instead of mid * mid < x
                lo = mid;
            }
            else if (mid == x / mid) {
                return mid;
            }
            else {
                hi = mid;
            }
        }
        if (mid > x / mid) {
            return mid - 1;
        }
        return mid;
        
    }
    //牛顿分割法。res = (res + x / res) / 2
    public int mySqrt(int x) {
        long r = x;//避免超出范围
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
    
    public int mySqrt(int x) {
        if(x < 4) return x == 0 ? 0 : 1;
        int res = 2 * mySqrt(x/4);
        if((res+1) * (res+1) <= x && (res+1) * (res+1) >= 0) return res+1;
        return res;
    }
}