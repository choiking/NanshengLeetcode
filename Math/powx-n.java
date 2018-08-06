//O(logn)
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                ++n;
                n = -n;
                x = 1 / x;
                return x * x * myPow(x * x, n / 2);
            }
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

//O(n / 2)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        int i = 0;
        double res = 1;
        double df = x * x;
        int abs = Math.abs(n);
        if (abs % 2 == 0) {
            while (i < abs / 2) {
                res = res * df;
                i++;
            }
        }
        else {
            while (i < abs / 2) {
                res = res * df;
                i++;
            }
            res = res * x;
        }
        if (n < 0) return 1 / res;
        return res;
    }
}
